/*highlight palabra*/
function replaceText() {

    $("body").find(".highlight").removeClass("highlight");

    var searchword = $("#palabrabuscada").val();

    var custfilter = new RegExp(searchword, "ig");
    var repstr = "<span class='highlight'>" + searchword + "</span>";

    if (searchword != "") {
        $('body').each(function() {
            $(this).html($(this).html().replace(custfilter, repstr));
        })
    }
}


/*change tamaño paragrafos*/
$(`#dropselsize li:nth-child(3) input`).click(function (){
    $("p").css("font-size", "large");
})
$(`#dropselsize li:nth-child(2) input`).click(function (){
    $("p").css("font-size", "medium");
})
$(`#dropselsize li:nth-child(1) input`).click(function (){
    $("p").css("font-size", "small");
})


/*selector theme*/
$(`#dropseltheme  li:nth-child(1) a`).click(function (){
    $("body").removeClass();
    $("body").addClass('bg-dark');
})
$(`#dropseltheme li:nth-child(2) a`).click(function (){
    $("body").removeClass();
    $("body").addClass('bg-light');
})
$(`#dropseltheme  li:nth-child(3) a`).click(function (){
    $("body").removeClass();
    $("body").addClass('bg-black');
})

/*alerta cookies*/
$(".btn-close").click(function (){
    alert("Has aceptat la política de privacitat i les galetes.")
})


/*reloj*/
var span = document.getElementById('reloj');
function time() {
    var d = new Date();
    var s = d.getSeconds();
    var m = d.getMinutes();
    var h = d.getHours();
    span.textContent =
        ("0" + h).substr(-2) + ":" + ("0" + m).substr(-2) + ":" + ("0" + s).substr(-2);
}
setInterval(time, 1000);
