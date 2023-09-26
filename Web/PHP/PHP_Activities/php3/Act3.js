$("#buton").on("click", function () {
    $.ajax({

        method: "GET",
        url: "Act3.php",
        data: {"num": $("#num").val()},
        dataType: 'json',
        success: function (data) {
            console.log(data);
            switch (data) {
                case 1:
                    $('#text').text("És múltiple de 5 i de 17.");
                    break;
                case 2:
                    $('#text').text("És múltiple de 17.");
                    break;
                case 3:
                    $('#text').text("És múltiple de 5.");
                    break;
                case 4:
                    $('#text').text("No és múltiple ni de 5 ni de 17.");
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