let final,exa1,exa2,exa3,nom;

$("tbody tr").each(function (alumne){
    exa1=parseInt($(`tbody tr:nth-child(${alumne+1}) td:nth-child(2)`).text());
    exa2=parseInt($(`tbody tr:nth-child(${alumne+1}) td:nth-child(3)`).text());
    exa3=parseInt($(`tbody tr:nth-child(${alumne+1}) td:nth-child(4)`).text());
    final=(exa1+exa2+exa3)/3;
    $(`tbody tr:nth-child(${alumne+1}) td:nth-child(5)`).text(final);
    if(final<5){
        $(`tbody tr:nth-child(${alumne+1}`).css("color","red");
    } else{$(`tbody tr:nth-child(${alumne+1}`).css("color","green");}
})

$("tr").mouseenter(function(event) {
    let nomp = $("#nom").val();
    if (nomp !=""){
        $(this).is(`:contains(${nomp})`) ?
            $(this).addClass("contains")
            :$(this).addClass("no-contains");
    }
});
$("tr").mouseleave(function(event) {$(this).prop("class", "");});







