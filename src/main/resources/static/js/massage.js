var index;
var layedit;
var layer;

layui.use('layedit', function(){
    layedit= layui.layedit;
    layer=layui.layer;
    layedit.set({
        uploadImage: {
            url: '../map/upload' //接口url
            ,type: 'post' //默认post
        }
    });

    index=layedit.build('message',{}); //建立编辑器
});

function submit() {

    var text=layedit.getContent(index);
   if(text==""){
       layer.msg("请输入内容")
       return
   }

    console.info(returnCitySN .cip+returnCitySN .cname);
    $.ajax({
        url:"../map/addmsg",
        type:"post",
        data:{ip:returnCitySN .cip,address:returnCitySN .cname,content:text},
        success:function (result) {

            layer.open({
                title:'==='
                ,content:result
                ,btn: ['确定']
                ,yes: function(index, layero){
                    //按钮【按钮一】的回调
                    history.go(0)
                }

            })

        }
    })
}


