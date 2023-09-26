$("#loginbutton").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'POST',
        url: 'loginPF.php',
        data: {"loginemail": $("#loginemail").val(), "password": $("#loginpassword").val()},
        dataType: 'json',
        success: function (data) {
            switch (data.status){
                case "ok":
                    console.log(data);
                    $("#loginmessage").css("color","green");
                    $("#loginmessage").text("WELCOME!");
                    setTimeout(
                        function()
                        {
                            $("#formlogin").modal('hide');
                            $('.modal-backdrop').remove();

                            $("#registeropenbutton").hide();
                            $("#loginopenbutton").hide();
                            $("#columnaaa").html('<a className = "nav-link bg-danger">BON DIA <b>'+ data.alias+'</b></a>')
                            $('#logoutbutton').modal('toggle');


                        }, 1000);

                    break;
                case "error":
                    console.log(data);
                    $("#loginmessage").css("color","red");
                    $("#loginmessage").text("wrong user/password");
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


