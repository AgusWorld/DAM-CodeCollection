let noiva=parseInt(prompt("Import Sense IVA??"))
let iva=parseInt(prompt("Quin IVA vols aplicar??"))

document.getElementById("noiva").innerText=noiva;
document.getElementById("iva").innerText=iva;
let preuambiva=(noiva/100*iva)+noiva;
document.getElementById("preuambiva").innerText=preuambiva;
