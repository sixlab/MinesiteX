$(function () {
    // wxMsg

    FastClick.attach(document.body);

    $(document).on("click", "#show-notification", function () {
        $.noti({
            title: "中奖啦！",
            text: "点击领取腾讯撸啊撸杯二等奖！",
            media: "<img src='./images/present.png' />",
            data: {
                message: "逗你玩的!"
            },
            time: 3000,
            onClick: function (data) {
                $.alert(data.message);
            }
        });
    });

    // 渲染所需模板
    var template = '<div>Hey! I am {{name}}!</div>';

    // 渲染所需数据
    var data = {name: 'Rosen'};

    // 模板的编译
    var compiledTemplate = Hogan.compile(template);

    // 模板的渲染
    var result = compiledTemplate.render(data);

    // 输出结果
    console.log(result);
});