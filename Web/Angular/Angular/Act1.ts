let botoneviar=document.getElementById("boton") as HTMLButtonElement;
botoneviar.addEventListener("click",conseguirnum);

let pe=document.getElementById("resultat") as HTMLTextAreaElement;
function conseguirnum(){
    let elementN:number=+(<HTMLInputElement>document.getElementById("numero")).value;
    if(elementN>=50 && elementN<=99){
        pe.innerText=("El numero "+elementN+" SI es troba en un rang de 50 a 99 ambdos inclusius");
    }else{
        pe.innerText=("El numero "+elementN+" NO es troba en un rang de 50 a 99 ambdos inclusius");
    }

}






