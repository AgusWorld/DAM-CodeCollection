/**GET ALL **/
$("#getall").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'GET',
        url: 'getAll.php',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jgXHR);
            alert("Error" + texStatus + " " + error);
            window.stop();
        },
    })
});
/**REGISTER**/
$("#register").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'POST',
        url: 'register.php',
        data: {"nom": $("#nom").val(), "password": $("#password").val()},
        dataType: 'json',
        success: function (data) {
            switch (data.message){
                case "wrong email":
                    console.log(data)
                    $("#mip").css("color","red");
                    $("#mip").text("Wrong Email");
                    break;
                case "User exists":
                    console.log(data)
                    $("#mip").css("color","red");
                    $("#mip").text("User Exists");
                    break;
                default :
                    console.log(data)
                    $("#mip").css("color","green");
                    $("#mip").text($("#nom").val());
                    break;
            }
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jgXHR);
            alert("Error" + texStatus + " " + error);
            window.stop();
        },
    })
})
/**LOGIN**/
$("#login").click(function (e){
    e.preventDefault();
    $.ajax({
        method: 'POST',
        url: 'login.php',
        data: {"nom": $("#nom").val(), "password": $("#password").val()},
        dataType: 'json',
        success: function (data) {
            switch (data.status){
                case "ok":
                    console.log(data);
                    $("#mip").css("color","green");
                    $("#mip").text($("#nom").val());
                    break;
                case "error":
                    console.log(data);
                    $("#mip").css("color","red");
                    $("#mip").text("wrong user/password”");
                    break;
            }
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jgXHR);
            alert("Error" + texStatus + " " + error);
            window.stop();
        },
    })
})