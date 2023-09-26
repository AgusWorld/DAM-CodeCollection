//a5
let ele1=parseInt(document.getElementById("ele1").innerText);
let ele2=parseInt(document.getElementById("ele2").innerText);
let ele3=parseInt(document.getElementById("ele3").innerText);
let ele4=parseInt(document.getElementById("ele4").innerText);
let ele5=parseInt(document.getElementById("ele5").innerText);
let pressupot=parseInt(document.getElementById("pressupost").innerText)
let total= ele1+ele2+ele3+ele4+ele5;
document.getElementById("total").innerText=total;

if (total>pressupot)
    document.getElementById("pots").innerText = "NO POTS COMPRAR TOT AIXO";
else
    document.getElementById("pots").innerText = "POTS COMPRAR TOT AIXO";