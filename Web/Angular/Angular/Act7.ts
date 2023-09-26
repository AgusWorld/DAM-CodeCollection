let dibutton=document.getElementById("button") as HTMLButtonElement;
dibutton.addEventListener("click",funcioAct7);

let diresult=document.getElementById("resultado")  as HTMLTextAreaElement;

function funcioAct7(){

    let horas:number=+((<HTMLInputElement>document.getElementById("number1")).value);
    let minuts:number=+((<HTMLInputElement>document.getElementById("number2")).value);
    let segons:number=+((<HTMLInputElement>document.getElementById("number3")).value);

    let arrayTime:[number,number,number]=[horas,minuts,segons];

    diresult.innerText=arrayTime[0]+":"+arrayTime[1]+":"+arrayTime[2];
}