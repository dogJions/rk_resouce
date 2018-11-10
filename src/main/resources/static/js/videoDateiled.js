
var dataList=[];
function f() {

    var cid=$("#cid").val();

    $.ajax({
            url:"../map/void_dateiled",
            type:"post",
            data:{cid:cid},
        success:function (result) {
                dataList=result;
                var lis=[];
                var i=1;
                $.each(result,function (key,value) {
                    // var str="'"+value.url+"'"
                    // console.info(str)
                    lis.push(
                        '<li onclick="f1(this)" id="li'+i+'">'+i+'</li>'
                    )
                    i++;
                });
            $("#uRl").html(result[0].url);
            $("#ul").html(lis.join(''));
            $("#li1").addClass("active");
        }
    })
}

$(function () {
    f();

})

//背景色转换
function f1(obj) {
    $(obj).addClass("active").siblings().removeClass("active");
    // console.info();
     var dataObj=dataList[$(obj).index()];
     $("#uRl").html(dataObj.url)
}