let noiva=parseInt(prompt("Import Sense IVA??"))
let iva=parseInt(prompt("Quin IVA vols aplicar??"))
let preuambiva=parseInt((noiva/100*iva)+noiva)
document.getElementById("noiva").innerText=noiva;
document.getElementById("iva").innerText=iva;


document.getElementById("preuambiva").innerText=preuambiva;

if (preuambiva>100)
    document.getElementById("preuambiva").style.backgroundColor = "red";
else
    document.getElementById("preuambiva").style.backgroundColor = "lime";