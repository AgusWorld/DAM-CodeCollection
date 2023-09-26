$(document).ready(function () {
    $.ajax({
        method: 'GET',
        url: 'https://jsonplaceholder.typicode.com/photos',
        dataType: 'json',
        success: function (data) {

            $.each(data, function () {
                /** Primero habia hecho esto pero no lo veia eficiente al ser un bucle each y tener que comprobar todos, asi que a
                 * al final hice lo que esta abajo de return false
                 if(this["albumId"]==1 && this["id"]<=10){
                    $("body").append("<p><b>Títol: </b>"+this["title"]+"</p><img src='"+this["thumbnailUrl"]+"'>")
                }
                 */
                $("body").append("<p><b>Títol: </b>"+this["title"]+"</p><img src='"+this["thumbnailUrl"]+"'>")
                if(this["id"]==10) return false;
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