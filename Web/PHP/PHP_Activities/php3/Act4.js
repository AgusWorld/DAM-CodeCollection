$("#buton").on("click", function () {
    $.ajax({

        method:"GET",
        url:"Act4.php",
        data: {"num":$("#num").val()},
        dataType:"json",
        success: function (data) {
            console.log(data);
            switch (data) {
                case 1:
                    $('#text').text("Es troba dintre de l’array.");
                    break;
                case 2:
                    $('#text').text("No es troba dintre de l’array.");
                    break;
            }
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log("Error: " + textStatus + " " + error);
            alert("Error: " + textStatus + " " + error);
        }
    });
})