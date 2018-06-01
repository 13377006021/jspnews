$(function () {
    function changgeBtn(str,disabled) {
        var obj = $("[class*=_btn]");
        if(disabled){
            obj.attr("disabled","disabled");
        }else{
            obj.removeAttr("disabled");
        }
        obj.attr("value",str);
    }

    $(".contacts_btn").click(function () {
        var username = $("input[name=username]").val();
        var email = $("input[name=email]").val();
        var phone = $("input[name=phone]").val();
        var qq  =   $("input[name=qq]").val();
        var title   =  $("input[name=title]").val();
        var content =  $("textarea[name=content]").val();
        username = W_trim(username);
        email = W_trim(email);
        phone = W_trim(phone);
        qq = W_trim(qq);
        title = W_trim(title);
        content = W_trim(content);
        if(W_empty(username) || W_empty(email) || W_empty(phone) || W_empty(qq) || W_empty(title)|| W_empty(content)){
            zeroModal.alert("所有选项都不可以为空!");
            return false;
        }else if(!W_isEmail(email)){
            zeroModal.alert("邮箱格式不正确！");
            return false;
        }else if(!W_isPhone(phone)){
            zeroModal.alert("手机号码不合法！");
            return false;
        }else if(!W_isQq(qq)){
            zeroModal.alert("qq号码不对！");
            return false;
        }else{
            changgeBtn("正在反馈",true);
            var info = "username="+username+"&email="+email+"&phone="+phone+"&qq="+qq+"&title="+title+"&content="+content;
            $.ajax({
                type:"post",
                url:"/ajax/ContactsController.do",
                async:true,
                data:info,
                dataType:'text',
                success:function(data){
                    changgeBtn("立即跳转",false);
                    var datas = eval('('+data+')');
                    if(datas.code==200){
                        zeroModal.success("反馈成功，即将跳转至主页...");
                        setTimeout('location="index.html"',2200);
                    }else if(datas.code==403){
                        zeroModal.error(datas.msg);
                    }else{
                        zeroModal.error("未知错误");
                    }
                }
            });
        }
    })
});
