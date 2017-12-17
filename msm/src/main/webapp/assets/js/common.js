var SRC = '';

function flushPage(src,time) {
    var src1 = '../' + src;
    alert($("#selectV").val());
    var data = "type=" + $("#selectV").val() + "&value=" + $("input[selectId='selectV']").val();
    $.ajax({
        url: src1,
        dataType: 'html',
        data: data,
        beforeSend: function() {
            $('#my-modal-loading').modal('open');
        },
        error: function() {
            $("#alert-message").html("菜单地址设置错误");
            $("#my-alert").modal('open');
        },
        timeout: function() {
            $("#alert-message").html("页面获取超时");
            $("#my-alert").modal('open');
        },
        success: function(data) {
            $("#admin-content-body").html(data);
        },
        complete: function() {
            if(time==1) {
                flushPagination(parseInt($("#Form").data("page")), parseInt($("#Form").data("max")), time);
            }
            $('#my-modal-loading').modal('close');
        }
    });

}


function flushFrom(src,time) {
    var src1 = '../' + src;
    var data = "type=" + $("#selectV").val() + "&value=" + $("input[selectId='selectV']").val();
    $.ajax({
        url: src1,
        dataType: 'html',
        type: 'post',
        data: data,
        beforeSend: function() {
            $('#my-modal-loading').modal('open');
        },
        error: function() {
            $("#alert-message").html("菜单地址设置错误");
            $("#my-alert").modal('open');
        },
        timeout: function() {
            $("#alert-message").html("页面获取超时");
            $("#my-alert").modal('open');
        },
        success: function(data) {
            $("#Form").html(data);
        },
        complete: function() {
            if(time==2){
                flushPagination(parseInt($("#Form").data("page")), parseInt($("#Form").data("max")), time);
            }
            $('#my-modal-loading').modal('close');
        }
    });

}

function flushPagination(totalData, showData,time) {
    $('.am-pagination').pagination({
        coping: true,
        homePage: '首页',
        endPage: '末页',
        prevContent: '上页',
        nextContent: '下页',
        totalData: totalData,
        showData: showData,
        activeCls: 'am-active',
        keepShowPN: true,
        callback: function(api) {
            if(time!=2) {
                flushFrom($("#Form").attr("action") + "/" + api.getCurrent(),time);
            }
        }
    }, function(api) {
        if(time!=2) {
            flushFrom($("#Form").attr("action") + "/" + 1);
        }

    });
}


function select(object){
	
}