let miarray=[];
for(let i=0;i<10;i++){miarray.push(Math.floor(Math.random()*10))}
document.body.innerHTML+=`<p>Array Original: ${miarray}</p>`;
let posicions=prompt("Quantes posicions s’han de moure els elements de l’array?");
for(let x=0;x<posicions;x++){
    let ultimo=miarray.pop();
    miarray.unshift(ultimo);
}
document.body.innerHTML+=`<p>Array Transfor: ${miarray}</p>`;