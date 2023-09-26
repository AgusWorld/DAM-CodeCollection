let cols=prompt("COLUMNAS???");
let rows=Math.floor(Math.random()*11);
document.body.innerHTML+= `<table id="taula"></table>`;

var row=document.createElement("tr");
for(let numcol=1;numcol<=cols;numcol++){
    var td = document.createElement("td");
    var texto = document.createTextNode(`Columna ${numcol}`);
    td.appendChild(texto);
    row.appendChild(td)
}
document.getElementById("taula").appendChild(row)


for(let i=1;i<rows;i++){
    var larow = document.createElement("tr");
    for(let ix=0;ix<cols;ix++){
        var eltd = document.createElement("td");
        var textotd = document.createTextNode(Math.floor(Math.random()*10));
        eltd.appendChild(textotd);
        larow.appendChild(eltd);
    }
    document.getElementById("taula").appendChild(larow);
}

var styles = `
    table{ 
        border: 3px solid black;
        text-align: center;
    }
    tr:first-child{ 
        color: lime;
        font-weight: bold;
    }
    td{ 
        border: 3px solid black;
    }
`
var styleSheet = document.createElement("style")
styleSheet.type = "text/css"
styleSheet.innerText = styles
document.head.appendChild(styleSheet)