function catalogOnclick(id,obj) {

    f(id, obj)
    $.ajax({
        url:  "../map/Catalog",
        type:"post",
        data:{pid:id},
        success:function (result) {

            var lis = [];
            if(result.rc[0]!=null){
                lis.push(

                    '<a onclick="f('+result.rc[0].pid+',this)" class="c-active">全部</a>'
                )
            }

            if(result.rc.length!=0){
                $("#t2").css("display", "block");
            }else {
                $("#t2").css("display", "none");
            }
            $("#t3").css("display", "none");

            $.each(result.rc, function (key, value) {
                lis.push(
                    '<a href="javaScript:void(0);"    onclick="catalogOnclick2('+value.id+',this)">'+value.name+'</a>'
                )
            });

            $("#item").html(lis.join(''));
        }
    })

}

function catalogOnclick2(id,obj) {
   // $("#t3").show();
    // $("#t3").slideToggle();
    f(id,obj)

    $.ajax({
        url:  "../map/Catalog",
        type:"post",
        data:{pid:id},
        success:function (result) {
            if(result.rc.length!=0){
                $("#t3").css("display", "block");
            }else {
                $("#t3").css("display", "none");
            }
        if(result.rc[0]!=null) {
            var lis = [];
            lis.push(
                '<a onclick="f('+result.rc[0].pid+',this)" class="c-active">全部</a>'
            )
        }
            $.each(result.rc, function (key, value) {
                lis.push(
                    '<a href="javaScript:void(0);" onclick="f('+value.id+', this)" >'+value.name+'</a>'
                )
            });
            $("#item2").html(lis.join(''));
        }
    })


}


function f(id,obj) {
    $(obj).addClass('c-active').siblings().removeClass('c-active');
    $("#pid").val(id)
    list()
}

//最新与最热
function f2(number,obj) {
    $(obj).addClass('order-active').siblings().removeClass('order-active');
    $("#hiv").val(number)
    list()
}

$(function () {
    list();
})

function list() {

    var cid=$("#pid").val();
    var hiv=$("#hiv").val();
    var pageNum=$("#pageNum").val()== undefined?1:$("#pageNum").val();
    
    $.ajax({
        url:  "../map/text_list",
        type:"post",
        data:{cid:cid,hiv:hiv,pageNum:pageNum,siteType:1},
        success:function (result) {
            var lis=[];

            if(result.size==0){
                lis.push(
                    '<div class="layadmin-tips">\n' +
                    '                <i class="layui-icon layui-icon-face-surprised"></i>\n' +
                    '                <i class="layui-icon layui-icon-face-surprised"></i>\n' +
                    '                <i class="layui-icon layui-icon-face-surprised"></i>\n' +
                    '                <div class="layui-text">\n' +
                    '                    <span>该分类标签暂无任何文章</span>\n' +
                    '                </div>\n' +
                    '            </div>'
                )
            }

            $.each(result.list,function (key,value) {
                var date=new Date(value.addTime).getFullYear()+"-"+new Date(value.addTime).getMonth()+"-"+new Date(value.addTime).getDay()
                lis.push(
                    '<div class="layui-card-body content-item" style="position: static;">\n' +
                    '\t\t\t\t\t\t\t<div class="layui-col-md4 left">\n' +
                    '\t\t\t\t\t\t\t\t\t \t<img src="'+value.thumbnailImg +'">\n'+
                    '\t\t\t\t\t\t\t</div>\n' +
                    '\t\t\t\t\t\t\t<div class="layui-col-md8 info">\n' +
                    '\t\t\t\t\t\t\t \t<h2><a href="../index/text_detailed?id='+value.id+' ">'+value.title+'</a></h2>\n' +
                    '\t\t\t\t\t\t\t \t<p class="summary">'+value.summary+'</p>\n' +
                    '\t\t\t\t\t\t\t \t<div class="meta">\n' +
                    '\t\t\t\t\t\t\t \t\t<div class="meta-left">\n' +
                    '\t\t\t\t\t\t\t\t \t\t<a>\n' +
                    '\t\t\t\t\t\t\t\t \t\t\t<i class="layui-icon layui-icon-username"></i>'+value.author +'\n' +
                    '\t\t\t\t\t\t\t\t \t\t\t\n' +
                    '\t\t\t\t\t\t\t\t \t\t</a>\n' +
                    '\t\t\t\t\t\t\t \t\t</div>\t\n' +
                    '\t\t\t\t\t\t\t \t\t<div class="meta-right">\n' +
                    '\t\t\t\t\t\t\t \t\t\t <a><i class="layui-icon"></i><span class="num"> '+value.clickCount +'</span></a>\n' +
                    '\t\t\t\t\t\t\t \t\t\t <span><i class="layui-icon layui-icon-log"></i>'+ date +'</span>\n' +
                    '\t\t\t\t\t\t\t \t\t</div>\n' +
                    '\t\t\t\t\t\t\t \t </div>\n' +
                    '\t\t\t\t\t\t\t </div>\n' +
                    '\t\t\t\t\t\t</div>'
                )
            })

            lis.push(
                '<input type="hidden" id="pageNum" value="'+result.pageNum+'">\n' +
                '\t\t\t\t\t<input type="hidden" id="pages" value="'+result.pages+'">'
            )

            // console.info(lis.join(''))
            $("#list").html(lis.join(''));

            var pages=$("#pages").val()==""||$("#pages").val()==undefined?1:$("#pages").val();
            console.info(pages);

            laypage({
                cont: 'page' //绑定到指定id
                ,pages: pages
                ,curr:pageNum
                ,jump: function(obj, first){
                    if(!first){
                        $("#pageNum").val(obj.curr);
                        list();
                    }
                }
            });

        }
    })
}

