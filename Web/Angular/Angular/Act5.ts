let theButton=document.getElementById("theButton") as HTMLButtonElement;
theButton.addEventListener("click",funcioAct5);

let resultado=document.getElementById("resultado")  as HTMLTextAreaElement;
function funcioAct5(){

    let fraseInicial:string=((<HTMLInputElement>document.getElementById("fraseInicial")).value).toLowerCase();
    let fraseARemplazar:string=((<HTMLInputElement>document.getElementById("fraseARemplazar")).value).toLowerCase();
    let fraseIntroducida:string=((<HTMLInputElement>document.getElementById("fraseIntroducida")).value).toLowerCase();

    resultado.innerText=(fraseInicial.replace(fraseARemplazar,fraseIntroducida));

}