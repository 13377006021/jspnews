$(function () {
    $("[id*=review_]").on("click",function () {
        var obj = $(this).parents("tr[id*=data_]");
        var ids = obj.attr("id");
        var s = ids.split("_");
        var type = s[1];
        var id = s[2];
        if($.trim(type)=="" && $.trim(id)==""){
            x0p('警告',
                '无法获取到目标类型数据，无法继续操作！',
                'error', false);
        }else{
            x0p({
                title: '是否审核此条新闻？',
                text: ''+type,
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
                    $.post("/ajax/NewsReviewController.do",{type:type,id:id},function(data) {
                        if(data.code==200){
                            x0p(data.msg, null, 'ok', false);
                            obj.hide(300);
                        }else if(data.code==403){
                            x0p(data.msg, null, 'error', false);
                        }else{
                            x0p('未知错误！', null, 'error', false);
                        }
                    },"json");
                }
            });
        }

    });
});
