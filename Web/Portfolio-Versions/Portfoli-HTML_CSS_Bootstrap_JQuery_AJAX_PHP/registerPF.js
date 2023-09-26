$("#registerbutton").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'POST',
        url: 'registerPF.php',
        data: {"regemail": $("#registeremail").val(),"regalias": $("#registeralias").val(),"regpassword": $("#registerpassword").val()},
        dataType: 'json',
        success: function (data) {
            switch (data.message){
                case "wrong email":
                    console.log(data)
                    $("#registermessage").css("color","red");
                    $("#registermessage").text("Wrong Email");
                    break;
                case "User exists":
                    console.log(data)
                    $("#registermessage").css("color","red");
                    $("#registermessage").text("User Exists");
                    break;
                default :
                    console.log(data)
                    $("#registermessage").css("color","green");
                    $("#registermessage").text("Registre Afegit correctament.");
                    setTimeout(
                        function()
                        {
                            $("#formregister").modal('hide');
                            $('.modal-backdrop').remove();
                            location.reload();
                        }, 1000);
                    break;
            }
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR);
            alert("Error" + textStatus + " " + error);
            window.stop();
        },
    })
})