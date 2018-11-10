function down(id) {

    // $.ajax({
    //     url:  "../map/down",
    //     type:"post",
    //     data:{id:id},
    //     success:function (result) {
    //
    //     }
    // })

    window.location.href='../map/down?id='+id;
}