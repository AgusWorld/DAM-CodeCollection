let button=document.getElementById("boton") as HTMLButtonElement;
button.addEventListener("click",funcioAct4);

let resultat=document.getElementById("resultat")  as HTMLTextAreaElement;
function funcioAct4(){
    let As:number=0;
    let Es:number=0;
    let Is:number=0;
    let Os:number=0;
    let Us:number=0;

    let EString:string=((<HTMLInputElement>document.getElementById("EString")).value).toLowerCase();
    for(let long:number=0;long<EString.length;long++){
        let actual:string=EString.charAt(long);
        switch (actual){
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
        resultat.innerText=("As: "+As+"\nEs: "+Es+"\nIs: "+Is+"\nOs: "+Os+"\nUs: "+Us);

}