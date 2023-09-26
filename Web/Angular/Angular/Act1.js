var botoneviar = document.getElementById("boton");
botoneviar.addEventListener("click", conseguirnum);
var pe = document.getElementById("resultat");
function conseguirnum() {
    var elementN = +document.getElementById("numero").value;
    if (elementN >= 50 && elementN <= 99) {
        pe.innerText = ("El numero " + elementN + " SI es troba en un rang de 50 a 99 ambdos inclusius");
    }
    else {
        pe.innerText = ("El numero " + elementN + " NO es troba en un rang de 50 a 99 ambdos inclusius");
    }
}
//# sourceMappingURL=Act1.js.map