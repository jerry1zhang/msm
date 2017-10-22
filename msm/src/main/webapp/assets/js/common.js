function flushPage(src) {
    $.ajax({
        url:src,
        dataType:'html',
        beforeSend:function () {
            $('#my-modal-loading').modal('open')
        },
        error:function () {
            $("#alert-message").html("菜单地址设置错误");
        },
        timeout:function () {
            $("#alert-message").html("页面获取超时");
        },
        success:function (data) {
            $("#admin-content").html();
        },
        complete:function () {
            $('#my-modal-loading').modal('close');
        }
    })

}