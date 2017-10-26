var SRC='';
function flushPage(src,data) {
    var src1 = '../'+src;
    $.ajax({
        url:src1,
        dataType:'html',
        beforeSend:function () {
            $('#my-modal-loading').modal('open');
        },
        error:function () {
            $("#alert-message").html("菜单地址设置错误");
            $("#my-alert").modal('open');
        },
        timeout:function () {
            $("#alert-message").html("页面获取超时");
            $("#my-alert").modal('open');
        },
        success:function (data) {
            $("#admin-content-body").html(data);
            SRC = src;
        },
        complete:function () {
            flushPagination(parseInt($("#listNum").val()),2);
            $('#my-modal-loading').modal('close');
        }
    });

}


function flushFrom(src) {
    var src1 = '../'+src;
    $.ajax({
        url:src1,
        dataType:'html',
        type:'post',
        beforeSend:function () {
            $('#my-modal-loading').modal('open');
        },
        error:function () {
            $("#alert-message").html("菜单地址设置错误");
            $("#my-alert").modal('open');
        },
        timeout:function () {
            $("#alert-message").html("页面获取超时");
            $("#my-alert").modal('open');
        },
        success:function (data) {
            $("#Form").html(data);

        },
        complete:function () {
            $('#my-modal-loading').modal('close');
        }
    });

}

function flushPagination(totalData,showData) {
    $('.am-pagination').pagination({
        coping:true,
        homePage:'首页',
        endPage:'末页',
        prevContent:'上页',
        nextContent:'下页',
        pageCount:totalData/showData,
        activeCls: 'am-active',
        keepShowPN:true,
        callback:function(api){
            api.setPageCount(totalData/showData);
            flushFrom($("#Form").attr("action")+"/"+api.getCurrent());
        }
    },function (api) {
        api.setPageCount(totalData/showData);
        flushFrom($("#Form").attr("action")+"/"+1);

    });
}


