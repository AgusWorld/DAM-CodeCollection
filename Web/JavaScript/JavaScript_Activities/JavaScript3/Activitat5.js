let arraynums=[];
for (let i=0;i<10;i++) {
    let num = prompt("NUM A AFEGIR?");
    arraynums.push(num);
}
let arrayparells=[];
for (let x = 0; x < arraynums.length; x++){
    if ((arraynums[x]%2)== 0) {
        arrayparells.push(arraynums[x]);
    }
}
document.body.innerHTML+=`Valors: ${arraynums}<br> Parells: ${arrayparells}`;