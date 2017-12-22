$(function () {
    $(".msx-item").click(function (e) {
        var itemId = $(this).attr('itemId');
        var status = $(this).prop('checked');

        console.log(itemId, status);

        $.ajax({
            url: "/assignment/pub/finish/" + itemId + "/" + status,
            type: "PUT",
            success: function (data) {
                if(!data.success){
                    alert(data.message);
                }
            }
        });
    });
});