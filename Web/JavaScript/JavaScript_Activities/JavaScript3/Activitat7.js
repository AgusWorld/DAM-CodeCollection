let tamany=prompt("MIDA DE LA MATRIU???");
let matriu=[];


//omplir matriu
for(let fila=0;fila<tamany;fila++){
    matriu[fila]=[];
    for(let columna=0;columna<tamany;columna++){matriu[fila][columna]=prompt(`NUM ${fila}-${columna}??`)}
}

//comprobar si es diagonal
let valor=matriu[0][0];
let totzero=new Boolean(true);
for(let fila=0;fila<tamany;fila++){
    for(let columna=0;columna<tamany;columna++){
        if (fila==columna && matriu[fila][columna]!=valor){totzero=false;}
        else if (fila!=columna && matriu[fila][columna]!=0){totzero=false;}
    }
}
if (totzero==true){document.body.innerHTML+=("Es diagonal")
} else {document.body.innerHTML+=("No és diagonal")}

//imprimir matriu
for(let fila=0;fila<tamany;fila++){
    document.body.innerHTML+=`<p>`;
    for(let columna=0;columna<tamany;columna++){
        document.body.innerHTML+=`${matriu[fila][columna]} `;
    }
    document.body.innerHTML+=`</p>`;
}