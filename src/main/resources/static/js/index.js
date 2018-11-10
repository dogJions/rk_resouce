layui.use(['carousel','element'], function(){
  var element = layui.element;
   var carousel = layui.carousel;
  carousel.render({
    elem: '#brand'
    ,width: '100%' //设置容器宽度
    ,height:'160px'
    ,arrow: 'none' //始终显示箭头
    ,indicator:'none'
    //,anim: 'updown' //切换动画方式
  });
});

$(function(){
	var mySwiper = new Swiper ('.swiper-container', {
		    direction: 'horizontal', // 垂直切换选项
		   	slidesPerView: 5,
		  	freeMode: true,
		  }); 
});

layui.use('flow',function () {
    var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
    var flow=layui.flow;
    flow.load({
        elem: '#list' //指定列表容器
        ,done:function (page,next) {//到达临界点（默认滚动触发），触发下一页
            var lis = [];
            //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
            $.get('../map/index_list?page='+page,function (res) {
                //你的列表返回在list集合中
                layui.each(res.list, function(index, item){
                    lis.push(
                        '<li class="content-item" >\n' +
                        '\t\t\t\t\t\t\t\t\t<div class="layui-col-md4 left">\n' +
                        '\t\t\t\t\t\t\t\t\t\t<img src="'+item.thumbnailImg+'">\n' +
                        '\t\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t\t<div class="layui-col-md8 info">\n' +
                        '\t\t\t\t\t\t\t\t\t\t<h2><a class="zidingyi-badge" >'+item.rcatalog+'</a>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t<a href="../index/text_detailed?id='+item.id+'" >'+item.title+'</a></h2>\n' +
                        '\t\t\t\t\t\t\t\t\t\t<p class="summary" >\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t  '+item.summary+'  \n' +
                        '\t\t\t\t\t\t\t\t\t\t</p>\n' +
                        '\t\t\t\t\t\t\t\t\t\t<div class="meta">\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t<div class="meta-left">\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t\t<a>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t\t\t<i class="layui-icon layui-icon-username"></i>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span ">'+ item.author+'</span>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t\t</a>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t<div  class="meta-right">\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t\t<a><i class="layui-icon">&#xe705;</i><span class="num" "> '+ item.clickCount+'</span></a>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t\t<span><i class="layui-icon layui-icon-log"></i><span ></span> </span>\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t</li>'
                    );
                });

                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                next(lis.join(''), page < res.pages);
            })
        }
    });
})



