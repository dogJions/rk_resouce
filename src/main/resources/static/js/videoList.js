function catalogOnclick(id,obj,lv) {
    f(id, obj)
    fl(id, obj, lv)

}

function fl(id,obj,lv) {
    if(lv==1){
        a="t2";
        b=2;
    }else if(lv==2){
        a="t3";
        b=3;
    }

    $.ajax({
        url:"../map/Catalog",
        type:"post",
        data:{pid:id},
        success:function (result) {
            var lis=[];

            //判断二三级分类
            if(lv==1) {
                if (result.rc.length != 0) {
                    $("#t2").css("display", "block");
                } else {
                    $("#t2").css("display", "none");
                }
                $("#t3").css("display", "none");
            }else if(lv==2){
                if(result.rc.length!=0){
                    $("#t3").css("display", "block");
                }else {
                    $("#t3").css("display", "none");
                }
            }

            if(result.rc.length!=0) {
                lis.push('<a onclick="f(' + result.rc[0].pid + ',this)" class="c-active">全部</a>')
                $.each(result.rc, function (key, value) {
                    lis.push(
                        '<a href="javaScript:void(0);"    onclick="catalogOnclick(' + value.id + ',this,'+ b + ')">' + value.name + '</a>'
                    )
                })

                $("#" + a + "").html(lis.join(''));
            }
        }
    })
}
//css背景转换
function f(id,obj) {
    $(obj).addClass('c-active').siblings().removeClass('c-active');
    $("#pid").val(id)
    list()
}

//最新与最热
function f2(number,obj) {
    $(obj).addClass('order-active').siblings().removeClass('order-active');
    $("#hiv").val(number);
    list()
}

$(function () {
    list()
})

function list() {
    var cid=$("#pid").val();
    var hiv=$("#hiv").val();
    var pageNum=$("#pageNum").val()== undefined?1:$("#pageNum").val();

    $.ajax({
        url:  "../map/text_list",
        type:"post",
        data:{cid:cid,hiv:hiv,pageNum:pageNum,siteType:2},
        success:function (result) {
            var lis=[];
            console.info(result.list.lenght)
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
            }else {
                $.each(result.list,function (key,value){
                    lis.push(
                        '<li>\n' +
                        '\t\t\t\t\t\t\t<a title="'+value.title+'" href="../index/video_detailed?id='+value.id+' ">\n' +
                        '\t\t\t\t\t\t\t\t<div class="img-box">\n' +
                        '\t\t\t\t\t\t\t\t\t<img src="'+value.thumbnailImg+'">\n' +
                        '\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t<em><i class="layui-icon  layui-icon-play"></i></em>\n' +
                        '\t\t\t\t\t\t\t\t<div class="abs-bg"></div>\n' +
                        '\t\t\t\t\t\t\t\t<div class="remark">\n' +
                        '\t\t\t\t\t\t\t\t\t<h3>'+value.title+'</h3>\n' +
                        '\t\t\t\t\t\t\t\t\t<p>'+value.summary+'</p>\n' +
                        '\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t</a>\n' +
                        '\t\t\t\t\t\t</li>'
                    )
                })
            }

            lis.push(
                '<input type="hidden" id="pageNum" value="'+result.pageNum+'">\n' +
                '\t\t\t\t\t<input type="hidden" id="pages" value="'+result.pages+'">'
            )

            // console.info(lis.join(''))
            $("#list").html(lis.join(''));

            var pages=$("#pages").val()==""||$("#pages").val()==undefined?1:$("#pages").val();
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