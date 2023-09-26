let dabutton=document.getElementById("button") as HTMLButtonElement;
dabutton.addEventListener("click",funcioAct6);

let daresult=document.getElementById("resultado")  as HTMLTextAreaElement;

function funcioAct6(){
    let frase:string=((<HTMLInputElement>document.getElementById("frase")).value).toLowerCase();
    let caracters : Set<String> = new Set<string>();
    for(let long:number=0;long<frase.length;long++) {
        let actual : string = frase.charAt(long);
        caracters.add(actual);
    }
    let myarray : Array<String> = (Array.from(caracters)).sort();

    daresult.innerText="El text "+frase+" té els següents caracters:";

    /** No he posat charactual:string perque donaria error al no ser suportat a un for(of) */
    for (let charactual of myarray){
        daresult.innerText+="\n"+charactual;
    }

}