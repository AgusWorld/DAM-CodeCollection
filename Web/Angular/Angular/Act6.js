var dabutton = document.getElementById("button");
dabutton.addEventListener("click", funcioAct6);
var daresult = document.getElementById("resultado");
function funcioAct6() {
    var frase = (document.getElementById("frase").value).toLowerCase();
    var caracters = new Set();
    for (var long = 0; long < frase.length; long++) {
        var actual = frase.charAt(long);
        caracters.add(actual);
    }
    var myarray = (Array.from(caracters)).sort();
    daresult.innerText = "El text " + frase + " té els següents caracters:";
    /** No he posat charactual:string perque donaria error al no ser suportat a un for(of) */
    for (var _i = 0, myarray_1 = myarray; _i < myarray_1.length; _i++) {
        var charactual = myarray_1[_i];
        daresult.innerText += "\n" + charactual;
    }
}
//# sourceMappingURL=Act6.js.map