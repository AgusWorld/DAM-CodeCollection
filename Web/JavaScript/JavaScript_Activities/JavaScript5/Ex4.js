var afegir = document.getElementById("afegir");
afegir.addEventListener("click", afegirjoc);
function afegirjoc() {
    var vg = document.getElementById('text').value;
    document.getElementById('colorSelect').innerHTML+=`<option>${vg}</option>`;
}
var deletear = document.getElementById("borrar");
deletear.addEventListener("click", esborrarjoc);
function esborrarjoc() {
    var deletearl = document.getElementById("colorSelect");
    deletearl.remove(deletearl.selectedIndex);
}