function replaceText() {

    $("body").find(".ressaltar").removeClass("ressaltar");

    let paraula = $("#text1").val();

    //Expressions regulars
    // https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Global_Objects/RegExp
    // Utilitzem una expressió regular per capturar totes les paraules i no ser case-sensitive.
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/RegExp/global
    // https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Global_Objects/RegExp/ignoreCase
    let expressio = new RegExp(paraula, "ig");
    let textressaltar = "<span class='ressaltar'>" + paraula + "</span>";

    if (paraula != "") {
        $('body').each(function() {
            $(this).html($(this).html().replace(expressio, textressaltar));
        })
    }
}