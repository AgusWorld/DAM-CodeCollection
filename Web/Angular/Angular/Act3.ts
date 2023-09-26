let boton=document.getElementById("boton") as HTMLButtonElement;
boton.addEventListener("click",funcioAct3);

let resultadoP=document.getElementById("resultat")  as HTMLTextAreaElement;
function funcioAct3(){
    let grados:number=+(<HTMLInputElement>document.getElementById("inputNumero")).value;
    let tipo:string=(<HTMLInputElement>document.getElementById("inputTipo")).value;

    if(tipo=="Celcius"){
        resultadoP.innerText=(grados+" graus Celcius són "+(grados*1.8+32)+" graus Fahrenheit");
    }else if(tipo=="Farenheit"){
        resultadoP.innerText=(grados+" graus Fahrenheit són "+((grados-32)/1.8)+" graus Celcius");
    }
}