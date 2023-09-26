var theButton = document.getElementById("theButton");
theButton.addEventListener("click", funcioAct5);
var resultado = document.getElementById("resultado");
function funcioAct5() {
    var fraseInicial = (document.getElementById("fraseInicial").value).toLowerCase();
    var fraseARemplazar = (document.getElementById("fraseARemplazar").value).toLowerCase();
    var fraseIntroducida = (document.getElementById("fraseIntroducida").value).toLowerCase();
    resultado.innerText = (fraseInicial.replace(fraseARemplazar, fraseIntroducida));
}
//# sourceMappingURL=Act5.js.map