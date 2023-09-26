var modificar = document.getElementById("modificar");
modificar.addEventListener("click", function(event){
    var columnes = document.getElementById("columna").value;
    var files = document.getElementById("fila").value;
    var numero = document.getElementById("valor").value;
    document.getElementById("taula").rows[files].cells[columnes-1].innerHTML = numero;
})