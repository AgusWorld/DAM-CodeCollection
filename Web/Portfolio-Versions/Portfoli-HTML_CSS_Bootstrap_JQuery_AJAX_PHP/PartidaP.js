$("#add5partidas").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'POST',
        url: 'PartidaP.php',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#aquisevencambios p").append(data[0]+" PUNTS "+data[5]+"<br>");
            $("#aquisevencambios p").append(data[1]+" PUNTS "+data[6]+"<br>");
            $("#aquisevencambios p").append(data[2]+" PUNTS "+data[7]+"<br>");
            $("#aquisevencambios p").append(data[3]+" PUNTS "+data[8]+"<br>");
            $("#aquisevencambios p").append(data[4]+" PUNTS "+data[9]+"<br>");
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR);
            alert("Error" + textStatus + " " + error);
            window.stop();
        },
    })
})

$("#enviar").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'POST',
        url: 'PartidaPupdate.php',
        data: {"jugador1": $("#JugadorRemove").val(), "jugador2": $("#JugadorAdd").val(),"points": $("#Points").val()},
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#aquisevencambios p").append("Partida amb id: "+data[4]+" de "+$("#JugadorRemove").val()+" ha pasat de "+data[0]+" punts a "+data[2]+" en restar els "+$("#Points").val()+" punts."+"<br>");
            $("#aquisevencambios p").append("Partida amb id: "+data[5]+" de "+$("#JugadorAdd").val()+" ha pasat de "+data[1]+" punts a "+data[3]+" en sumar els "+$("#Points").val()+" punts."+"<br>");


            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR);
            alert("Error" + textStatus + " " + error);
            window.stop();
        },
    })
})