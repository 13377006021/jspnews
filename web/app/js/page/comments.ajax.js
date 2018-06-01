var CommentsReplyNowObjId;
var CommentsReplyCount = 0;
$(function () {
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };

   $("a[id*=commentsReply_]").click(function () {
        if(CommentsReplyCount==0){
            CommentsReplyNowObjId = $(this).prop("id");
            ++CommentsReplyCount;
        }else{
            if($(this).prop("id")!=CommentsReplyNowObjId){
                $("#"+CommentsReplyNowObjId).children("span").children("em").html("回复");
                CommentsReplyNowObjId = $(this).prop("id");
            }
        }
       var oldObj = $("#oldCommentsReply");
       var parentObj = $("#commentsReply");
       parentObj.children("textarea").val("");
       var attrId = $(this).prop("id");
       var id = (attrId.split("_"))[1];
       var textObj = $(this).parent().parent();
       var replyObj = $(this).children("span").children("em");
       var tips = replyObj.html();
       var checkClass = textObj.children("#commentsReply").attr("class");
       if(checkClass==undefined){
           textObj.append(parentObj);
       }
       if(tips=="回复"){
           replyObj.html("取消回复");
       }else{
           oldObj.append(textObj.children("#commentsReply"));
           replyObj.html("回复");
       }
   });


   //点赞
    $("a[id*=commentsLike_]").click(function () {
        var oldObj = $("#oldCommentsReply");
        var attrId = $(this).prop("id");
        var id = (attrId.split("_"))[1];
        var textObj = $(this).parent().parent();
        var replyObj = $(this).children("span").children("d");
        var temp=$(this).children("span").children("b");
        var t=temp.html();
        var tips = replyObj.html();
        if(tips=="赞"){
            replyObj.html("已赞");
            temp.html(parseInt(t)+1);
        }else{
            oldObj.append(textObj.children("#commentsLike"));
            replyObj.html("赞");
            temp.html(parseInt(t)-1);
        }
        var info="id="+id+"&type="+tips;
        $.ajax({
            type:"post",
            url:"/ajax/CommentsDataController.do",
            async:true,
            data:info,
            dataType:'text',
            success:function(data){
                var datas = eval('('+data+')');
                if(datas.code==200){

                }else if(datas.code==403){
                    zeroModal.error(datas.msg);
                }else{
                    zeroModal.error("未知错误");
                }
            }
        });
    });



    /*发送评论*/
    $(".comments-submit").click(function () {
        var oldObj = $("#oldCommentsReply");
        var textObj = $("#commentsReply");
        var idObj = $(this).parent().parent();
        var newsId = ($("#article").prop("class").split("_"))[1];
        var id = (idObj.prop("id").split("_"))[1];
        var ullength = $(".comments-list ul li").length;
        var type="insert";
        var username = $(this).parent().parent().parent().find(".username").html();
        debugger
        if(id==undefined){
            id = 0;
        }
        if(!checkIsNumber(id) || !checkIsNumber(newsId)){
            zeroModal.error("参数提取错误,无法执行评论操作!");
        }else{
            var text = textObj.children("textarea").val();
            text = $.trim(text);
            if(text==""){
                zeroModal.error("评论内容不能为空!");
            }else if(text.length>255){
                zeroModal.error("评论字符不能超过255个字符!");
            }else{
                $.post("/ajax/CommentsDataController.do",{text:text,id:id,newsId:newsId,type:type},function(data) {
                    debugger
                    if(data.code==200){
                        if(id!=0){
                            var appendStr = "<div class=\"c1\" style=\"background-color:#f7f7f7;" +
                                "border-radius:5px;padding:10px 10px\">\n" +
                                "    <div class=\"gravatar\">\n" +
                                "        <img src=\""+data.grava+"\" alt=\""+data.username+"\">\n" +
                                "    </div>\n" +
                                "    <div class=\"username\">"+data.username+"</div>\n" +
                                "    <div class=\"clear_float\"></div>\n" +
                                "    <div class=\"text\" id=\"commentsText_2\">\n" +
                                "        <p class=\"z\"><a class=\"upUser\">@"+username+"</a>"+data.text+"\n" +
                                "        </p>\n" +
                                "        <div class=\"info\">\n" +
                                // "            <span><i class=\"fa fa-paper-plane-o\"></i>#0</span>\n" +
                                "            <span><i class=\"fa fa-clock-o\"></i>"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</span>\n" +
                            /*    "            <a><span><i class=\"fa fa-thumbs-o-up\"></i>0</span></a>\n" +*/
                                "        </div>\n" +
                                "        <div class=\"clear_float\"></div>\n" +
                                "    </div>\n" +
                                "</div>";
                            textObj.parent().after(appendStr);
                        }else if(ullength==0){
                            var appendStr = [];
                            appendStr.push( "<ul class=\"ul-list\"><li style=\"background-color:#f7f7f7;" +
                                "border-radius:5px;padding:10px 10px\">\n" +
                                "    <div class=\"gravatar\">\n" +
                                "        <img src=\""+data.grava+"\" alt=\""+data.username+"\">\n" +
                                "    </div>\n" +
                                "    <div class=\"username\">"+data.username+"</div>\n" +
                                "    <div class=\"clear_float\"></div>\n" +
                                "    <div class=\"text\" id=\"commentsText_2\">\n" +
                                "        <p class=\"z\">"+data.text+"\n" +
                                "        </p>\n" +
                                "        <div class=\"info\">\n" +
                                // "            <span><i class=\"fa fa-paper-plane-o\"></i>#0</span>\n" +
                                "            <span><i class=\"fa fa-clock-o\"></i>"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</span>\n" +
                                /*  "            <a><span><i class=\"fa fa-thumbs-o-up\"></i>0</span></a>\n" +*/
                                "        </div>\n" +
                                "        <div class=\"clear_float\"></div>\n" +
                                "    </div>\n" +
                                "</li><li class=\"start\">精彩评论</li></ul>");
                            $(".comments-list").append(appendStr.join(""));
                        } else{
                            var appendStr = "<li style=\"background-color:#f7f7f7;" +
                                "border-radius:5px;padding:10px 10px\">\n" +
                                "    <div class=\"gravatar\">\n" +
                                "        <img src=\""+data.grava+"\" alt=\""+data.username+"\">\n" +
                                "    </div>\n" +
                                "    <div class=\"username\">"+data.username+"</div>\n" +
                                "    <div class=\"clear_float\"></div>\n" +
                                "    <div class=\"text\" id=\"commentsText_2\">\n" +
                                "        <p class=\"z\">"+data.text+"\n" +
                                "        </p>\n" +
                                "        <div class=\"info\">\n" +
                                // "            <span><i class=\"fa fa-paper-plane-o\"></i>#0</span>\n" +
                                "            <span><i class=\"fa fa-clock-o\"></i>"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</span>\n" +
                              /*  "            <a><span><i class=\"fa fa-thumbs-o-up\"></i>0</span></a>\n" +*/
                                "        </div>\n" +
                                "        <div class=\"clear_float\"></div>\n" +
                                "    </div>\n" +
                                "</li>";
                            $(".comments-list>.ul-list>li:first").before(appendStr);
                        }
                        $(".comments-not").hide();
                        textObj.parent().children(".info").children("a").children("span").children("em").html("回复");
                        oldObj.append(textObj);
                        textObj.children("textarea").val("");
                    }else if(data.code==403){
                        zeroModal.error(data.msg);
                    }else{
                        zeroModal.error("未知错误");
                    }
                },"json");
            }
        }
    });

});