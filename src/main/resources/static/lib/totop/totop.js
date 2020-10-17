$(window).scroll(function() {
    $(window).scrollTop() > $(window).height()*0.5 ? $("#totop").addClass("show") : $("#totop").removeClass("show");
});

$("#totop").click(function() {
    $("#totop").addClass("launch");
    $("html, body").animate({
        scrollTop: 0
    }, 1000, function() {
        $("#totop").removeClass("show launch");
    });
    return false;
});