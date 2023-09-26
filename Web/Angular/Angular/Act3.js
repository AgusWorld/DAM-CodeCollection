var boton = document.getElementById("boton");
boton.addEventListener("click", funcioAct3);
var resultadoP = document.getElementById("resultat");
function funcioAct3() {
    var grados = +document.getElementById("inputNumero").value;
    var tipo = document.getElementById("inputTipo").value;
    if (tipo == "Celcius") {
        resultadoP.innerText = (grados + " graus Celcius són " + (grados * 1.8 + 32) + " graus Fahrenheit");
    }
    else if (tipo == "Farenheit") {
        resultadoP.innerText = (grados + " graus Fahrenheit són " + ((grados - 32) / 1.8) + " graus Celcius");
    }
}
//# sourceMappingURL=Act3.js.map