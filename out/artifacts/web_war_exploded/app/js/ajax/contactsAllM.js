$(function () {
    $("[class*=edit_contacts]").on("click",function () {
        var userIDObj = $("#userID");
        var userNameObj = $("#userName");
        var emailObj = $("#email");
        var phoneObj = $("#phone");
        var qqObj = $("#qq");
        var titleObj = $("#title");
        var contentObj = $("#content");
        var tjdateObj = $("#tjdate");
        var IPObj = $("#ip");
        var obj = $(this).parents("tr[id*=data_]");
        var ids = obj.attr("id");
        var s = ids.split("_");
        ids = s[2];
        if($.trim(ids)==""){
            x0p('警告',
                '无法获取到目标类型数据，无法继续操作！',
                'error', false);
        }else{
            $.post("/ajax/ContactsAllMController.do",{id:ids,type:"select"},function(data) {
                if(data.code==200){

                    userIDObj.val(data.id);
                    userNameObj.val(data.username);
                    emailObj.val(data.Email);
                    phoneObj.val(data.Phone);
                    qqObj.val(data.Qq);
                    titleObj.val(data.Title);
                    contentObj.val(data.Content);
                    tjdateObj.val(data.Tjdate);
                    IPObj.val(data.Ip);
                    $(".row_edit_user").show(300);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
});