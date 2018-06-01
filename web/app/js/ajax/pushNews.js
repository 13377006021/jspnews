$(function () {
    $(".push_news").on("click",function () {
        var info = [];
        info[0] = $("input[name=news_title]").val();
        info[1] = $("input[name=tags]").val();
        info[2] = $("input[name=slideImg]").val();
        info[3] = $("input[name=impnews]").is(":checked");
        info[4] = $("input[name=slide]").is(":checked");
        info[5] = $("select[name=new_category]").val();
        info[6] = $("textarea[name=content]").val();
        for(var i=0;i<info.length;i++){
            info[i] = $.trim(info[i]);
        }
        info[3] = info[3]=="true" ? 1 : 0;
        info[4] = info[4]=="true" ? 1 : 0;
        var pattern = new RegExp("[~'!@#￥$%^&*()-+_=:]");
        console.log(pattern.test(info[0]));
        debugger;
        if(info[0]==""){
            x0p("新闻标题不能为空", null, 'error', false);
            return false;
        }else if(pattern.test(info[0])){
            x0p("新闻标题不能为特殊字符", null, 'error', false);
            return false;
        }else if(info[5]==""){
            x0p("新闻分类不能为空", null, 'error', false);
            return false;
        }else if(info[6]==""){
            x0p("内容不能为空", null, 'error', false);
            return false;
        }else{
            var infos = {title:info[0],category:info[5],text:info[6],tag:info[1],slide:info[4],impnews:info[3],
                slideImg:info[2],type:"add"};
            $.post("/ajax/EditorController.do",infos,function(data) {
                if(data.code==200){
                    x0p(data.msg+"<br>即将返回", null, 'ok', false);
                    setTimeout('location="editor.html"',1500);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p("未知错误", null, 'error', false);
                }
            },"json");
        }
    });
    $(".update_news").on("click",function () {
        var info = [];
        info[0] = $("input[name=news_title]").val();
        info[1] = $("input[name=tags]").val();
        info[2] = $("input[name=slideImg]").val();
        info[3] = $("input[name=impnews]").is(":checked");
        info[4] = $("input[name=slide]").is(":checked");
        info[5] = $("select[name=new_category]").val();
        info[6] = $("textarea[name=content]").val();
        info[7] = $("input[name=news_id]").val();
        for(var i=0;i<info.length;i++){
            info[i] = $.trim(info[i]);
        }
        info[3] = info[3]=="true" ? 1 : 0;
        info[4] = info[4]=="true" ? 1 : 0;
        var pattern = new RegExp("[~'!@#￥$%^&*()-+_=:]");
        if(info[0]==""){
            x0p("新闻标题不能为空", null, 'error', false);
            return false;
        }else if(pattern.test(info[0])){
            x0p("新闻标题不能为特殊字符", null, 'error', false);
            return false;
        }else if(info[5]==""){
            x0p("新闻分类不能为空", null, 'error', false);
            return false;
        }else if(info[6]==""){
            x0p("内容不能为空", null, 'error', false);
            return false;
        }else if(info[7]==""){
            x0p("标识为空,不能进行修改", null, 'error', false);
            return false;
        }else{
            var infos = {title:info[0],category:info[5],text:info[6],tag:info[1],slide:info[4],impnews:info[3],
                        slideImg:info[2],id:info[7],type:"up"};
            $.post("/ajax/EditorController.do",infos,function(data) {
                if(data.code==200){
                    x0p(data.msg+"<br>即将转至新闻管理页", null, 'ok', false);
                    setTimeout('location="newsAll.html"',1500);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p("未知错误", null, 'error', false);
                }
            },"json");
        }
    });

    /*
   * 图片上传
   * */
    $("#gravaSubmit").click(function () {
        x0p({
            title: '是否将图片设置为已选择文件？1',
            text: '将上传成功之后，之前的图片将会被替换掉并无法找回。',
            icon: 'info',
            animationType: 'fadeIn',
            buttons: [
                {
                    type: 'info',
                    text: '确认',
                    showLoading: true

                },
                {
                    type: 'cancel',
                    text: '取消'
                }
            ]
        }, function(button) {
            if(button == 'info') {
                $.ajaxFileUpload({
                        url:'/user/U_uploadSlideImgController?type=grava',
                        secureuri:false,
                        fileElementId:'userImg',
                        dataType: 'text',
                        success: function(data)
                        {
                            datas = eval('('+data+')');
                            if(datas.code==200){
                                $("#slideImg").prop("value",datas.url);
                                x0p(datas.msg, null, 'ok', false);
                            }else{
                                x0p(datas.msg, null, 'error', false);
                            }

                        },
                        error: function ()
                        {
                            x0p('上传失败！', null, 'error', false);
                        }
                    }
                );
            }
        });

    });
});