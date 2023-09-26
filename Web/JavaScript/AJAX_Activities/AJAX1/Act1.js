$(document).ready(function () {
    $.ajax({
        method: 'GET',
        url: 'https://jsonplaceholder.typicode.com/users',
        dataType: 'json',
        success: function (data) {
            $.each(data, function () {
                $('tbody').append('<tr><td>'+this["id"]+'</td><td>'+this["name"]+'</td><td>'+this["username"]+'</td></tr>');
            });
            window.stop();
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jgXHR);
            alert("Error" + texStatus + " " + error);
            window.stop();
        },
    })
})