
function funcio2(){
    let frase=prompt("Cadena d'1 o més caracters??");
    let primer=frase.charAt(0);
    let ultim=frase.charAt(frase.length-1);
    //frase=frase.slice(1,-1);
    frase=frase.substring(1,frase.length-1);
    frase=ultim+frase+primer;
    document.body.innerText+=frase
}
