var isPassword = false;
$(function () {
    var className='';
    $("#zh_yzm").hide();
    function getCheckCode() {
        var obj = $("#checkImg");
        var s = obj.attr("src");
        obj.attr("src",s+"?"+new Date().getTime());
    }
    function getSrceenWH(){
        var w='';
        var h='';
        w = $(window).width();
        h = $(window).height();
        $('#dialogBg').width(w).height(h);
    }


    $(".tj_yzm").click(function (){
        var yzm=$("input[name=yzm]").val();
        var add_yzm=$.cookie('secondsremained_yzm');
        if(yzm!=add_yzm){
            zeroModal.error("验证码不对");
        }else {
            //getSrceenWH();
            //显示弹框
            var className = $(this).attr('class');
            $('#dialogBg').fadeIn(300);
            $('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
        }
    });
    //关闭弹窗
    $('.claseDialogBtn').click(function(){
        $('#dialogBg').fadeOut(300,function(){
            $('#dialog').addClass('bounceOutUp').fadeOut();
        });
    });
    $(".retPassword_btn").click(function () {
        var email = $("input[name=email]").val();
        var checkCode = $("input[name=verCode]").val();
        email = W_trim(email);
        checkCode = W_trim(checkCode);
        if(W_empty(email) ||  W_empty(checkCode)){
            zeroModal.alert("所有选项都不可以为空!");
            return false;
        }else{
            sendCode($(".retPassword_btn"));
            var info = "email="+email+"&checkCode="+checkCode+"&type=ret";
            $.ajax({
                type:"post",
                url:"/ajax/RetpasswordController.do",
                async:true,
                data:info,
                dataType:'text',
                success:function(data){
                    getCheckCode();
                    var datas = eval('('+data+')');
                    if(datas.code==200){
                        debugger;
                        $("#zh_yzm").show();
                        isPassword = true;
                        $.cookie('secondsremained_yzm', datas.msg, { expires: 1, path: '/' });
                    }else if(datas.code==403){
                        zeroModal.error(datas.msg);
                    }else{
                        zeroModal.error("未知错误");
                    }
                    debugger;
                }

            });

        }

    });
    $('.submit_Btn').click(function(){
        var email = $("input[name=email]").val();
        var password=$("input[name=new_password]").val();
        var password_2=$("input[name=new_password_2]").val();
        var yzm_code=$.cookie('secondsremained');
        if(yzm_code!=null){
            if(password!=password_2){
                alert("两次输入不一致");
                getSrceenWH();
                //显示弹框
                className = $(this).attr('class');
                $('#dialogBg').fadeIn(300);
                $('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
            }else {
               // getSrceenWH();
                var info = "password="+password+"&email="+email+"&type=retpassword";
                $.ajax({
                    type:"post",
                    url:"/ajax/RetpasswordController.do",
                    async:true,
                    data:info,
                    dataType:'text',
                    success:function(data){
                        console.log(data);
                        var datas = eval('('+data+')');
                        debugger;
                        if(datas.code==200){
                            $('.submit_Btn').val('更新成功');
                            zeroModal.success(datas.msg);
                        }else if(datas.code==403){
                            zeroModal.error(datas.msg);
                        }else{
                            zeroModal.error("未知错误");
                        }
                        debugger;
                    }
                });
            }
        }
    });
});

//发送验证码
function sendCode(obj){
        var date = new Date();
        addCookie("secondsremained",date.toGMTString(),120);//添加cookie记录,有效时间60s
        setCoutDown(date,obj);
}
function setCoutDown(date,obj) {
    var time_difference ;
    var count_down ;
    var nowDate;
    nowDate = new Date();
    time_difference = ((nowDate- date)/1000).toFixed(0);
    count_down = 120 - time_difference;
    //console.log(count_down);
    if(count_down<=0){
        obj.removeAttr("disabled");
        obj.val("免费获取验证码");
        addCookie("secondsremained","",120);//添加cookie记录,有效时间60s
        return;
    }
    obj.attr("disabled", true);
    obj.val("重新发送(" + count_down + ")");
    setTimeout(function() { setCoutDown(date,obj) },1000) //每1000毫秒执行一次
}
//发送验证码时添加cookie
function addCookie(name,value,expiresHours){
//判断是否设置过期时间,0代表关闭浏览器时失效
    if(expiresHours>0){
        var date=new Date();
        date.setTime(date.getTime()+expiresHours*1000);
        $.cookie(name, escape(value), {expires: date});
    }else{
        $.cookie(name, escape(value));
    }
}
