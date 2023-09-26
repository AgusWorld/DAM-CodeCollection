var dibutton = document.getElementById("button");
dibutton.addEventListener("click", funcioAct7);
var diresult = document.getElementById("resultado");
function funcioAct7() {
    var horas = +(document.getElementById("number1").value);
    var minuts = +(document.getElementById("number2").value);
    var segons = +(document.getElementById("number3").value);
    var arrayTime = [horas, minuts, segons];
    diresult.innerText = arrayTime[0] + ":" + arrayTime[1] + ":" + arrayTime[2];
}
//# sourceMappingURL=Act7.js.map