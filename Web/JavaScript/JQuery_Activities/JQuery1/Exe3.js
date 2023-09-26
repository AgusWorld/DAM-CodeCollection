$("ul li:nth-child(1)").click(function (){
    $("body").removeClass();
    $("body").addClass('bg-primary');
   // $("body").css("background-color","blue")
})
$("ul li:nth-child(2)").click(function (){
    $("body").removeClass();
    $("body").addClass('bg-dark');
    //$("body").css("background-color","black")
})
$("ul li:nth-child(3)").click(function (){
    $("body").removeClass();
    $("body").addClass('bg-secondary');
   // $("body").css("background-color","grey")
})

//lo habia hecho con lo comentado pero al recordar
//que era Jquery+Bootstrap lo he cambiado.