let botoneviarr=document.getElementById("boton") as HTMLButtonElement;
botoneviarr.addEventListener("click",funcioAct2);

let pee=document.getElementById("resultat") as HTMLTextAreaElement;
function funcioAct2(){
    let elementN1:number=+(<HTMLInputElement>document.getElementById("numero1")).value;
    let elementN2:number=+(<HTMLInputElement>document.getElementById("numero2")).value;
    let elementN3:number=+(<HTMLInputElement>document.getElementById("numero3")).value;

    if(elementN1>=elementN2 && elementN1>=elementN3){
        pee.innerText=("El numero més gran es el "+elementN1+"\nLa mitja es: "+((elementN1+elementN2+elementN3)/3));
    }else if(elementN2>=elementN1 && elementN2>=elementN3){
        pee.innerText=("El numero més gran es el "+elementN2+"\nLa mitja es: "+((elementN1+elementN2+elementN3)/3));
    }else if(elementN3>=elementN1 && elementN3>=elementN2){
        pee.innerText=("El numero més gran es el "+elementN3+"\nLa mitja es: "+((elementN1+elementN2+elementN3)/3));
    }
}