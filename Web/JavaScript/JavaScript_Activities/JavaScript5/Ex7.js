i=5;
function mourecuadrats() {this.style.marginTop="10pt";}
function nomourequadrats() {this.style.marginTop="0pt";}
let move = document.getElementsByClassName("intern");
for(let ii = 0; ii < move.length; ii++) {
    move[ii].addEventListener("mouseout", nomourequadrats); move[ii].addEventListener("mouseover", mourecuadrats);
}
function afegeix() {
    var box = document.createElement("div");
    box.classList.add("intern");
    box.innerHTML = i;
    i++;
    document.getElementById("flexbox-container").appendChild(box);
}
function elimina() {
    var interns = document.getElementById("flexbox-container").children;
    document.getElementById("flexbox-container").removeChild(interns[interns.length-1]);
    i--;
}

document.getElementById("borrar").setAttribute("onclick","elimina()");
document.getElementById("afegir").setAttribute("onclick","afegeix()");