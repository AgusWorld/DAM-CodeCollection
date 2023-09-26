var botoneviarr = document.getElementById("boton");
botoneviarr.addEventListener("click", funcioAct2);
var pee = document.getElementById("resultat");
function funcioAct2() {
    var elementN1 = +document.getElementById("numero1").value;
    var elementN2 = +document.getElementById("numero2").value;
    var elementN3 = +document.getElementById("numero3").value;
    if (elementN1 >= elementN2 && elementN1 >= elementN3) {
        pee.innerText = ("El numero més gran es el " + elementN1 + "\nLa mitja es: " + ((elementN1 + elementN2 + elementN3) / 3));
    }
    else if (elementN2 >= elementN1 && elementN2 >= elementN3) {
        pee.innerText = ("El numero més gran es el " + elementN2 + "\nLa mitja es: " + ((elementN1 + elementN2 + elementN3) / 3));
    }
    else if (elementN3 >= elementN1 && elementN3 >= elementN2) {
        pee.innerText = ("El numero més gran es el " + elementN3 + "\nLa mitja es: " + ((elementN1 + elementN2 + elementN3) / 3));
    }
}
//# sourceMappingURL=Act2.js.map