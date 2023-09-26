var button = document.getElementById("boton");
button.addEventListener("click", funcioAct4);
var resultat = document.getElementById("resultat");
function funcioAct4() {
    var As = 0;
    var Es = 0;
    var Is = 0;
    var Os = 0;
    var Us = 0;
    var EString = (document.getElementById("EString").value).toLowerCase();
    for (var long = 0; long < EString.length; long++) {
        var actual = EString.charAt(long);
        switch (actual) {
            case 'a':
                As++;
                break;
            case 'é':
            case 'è':
            case 'e':
                Es++;
                break;
            case 'i':
                Is++;
                break;
            case 'ó':
            case 'ò':
            case 'o':
                Os++;
                break;
            case 'u':
                Us++;
                break;
        }
    }
    resultat.innerText = ("As: " + As + "\nEs: " + Es + "\nIs: " + Is + "\nOs: " + Os + "\nUs: " + Us);
}
//# sourceMappingURL=Act4.js.map