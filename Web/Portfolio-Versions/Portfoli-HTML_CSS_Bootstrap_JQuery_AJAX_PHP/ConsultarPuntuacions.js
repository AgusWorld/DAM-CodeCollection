$("#buttonPuntuaciones").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'POST',
        url: 'ConsultarPuntuacions.php',
        data: {"nombre": $("#nombrePuntuaciones").val()},
        dataType: 'json',
        success: function (data) {
            $.each(data, function () {
                $('#cuerpodetabla').append('<tr><td>'+this["idpartida"]+'</td><td>'+this["alias"]+'</td><td>'+this["punts"]+'</td></tr>');
            });
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR);
            alert("Error" + textStatus + " " + error);
            window.stop();
        },
    })
})
$("#buttonPuntuacionesVaciar").click(function (){
    $("#cuerpodetabla").empty();
})

