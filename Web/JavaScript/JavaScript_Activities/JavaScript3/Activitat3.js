function conversorsegons(){
    function float2int (value) {return value | 0;}
    let segons=prompt("Nombre de segons?");
    let dias=float2int(parseInt(segons)/86400);
    let horas=float2int(parseInt(segons)%86400/3600);
    let minuts=float2int(parseInt(segons)%86400%3600/60);
    segons=float2int(parseInt(segons)%86400%3600%60);
    document.body.innerHTML+=`<h2>${dias} dies ${horas} horas ${minuts} minuts ${segons} segons</h2>`
}
function conversorsegons2(){
    let segons=prompt("Nombre de segons?");
    let dias=segons / 86400;
    let horas=segons % 86400/ 3600;
    let minuts=segons % 86400 % 3600 / 60;
    segons=segons % 86400 % 3600 % 60;

    document.body.innerHTML+=`<h2>${parseInt(dias)} dies ${parseInt(horas)} horas ${parseInt(minuts)} minuts ${parseInt(segons)} segons</h2>`
}