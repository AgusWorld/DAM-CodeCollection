$("#buton").on("click", function () {
    $.ajax({

        method: "GET",
        url: "Act5.php",
        data: {"sou": $("#sou").val(), "hisenda": $("#hisenda").val(), "seguretat": $("#seguretat").val()},
        dataType: 'json',
        success: function (data) {
            console.log(data);
            $("#text").text("Sou net: " + data);
            window.stop();
        },

        error: function (jqXHR, textStatus, error) {
            console.log("Error: " + textStatus + " " + error);
            alert("Error: " + textStatus + " " + error);
        }

    });
})