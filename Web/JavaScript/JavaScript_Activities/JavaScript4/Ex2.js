let persones=[
    {"nom":"RAUL","cognoms":"MACIAS DURAN"},
    {"nom":"PEPE","edat":42},
    {"nom":"CALIL","cognoms":"DEL MONTE","edat":11}
];

function takeobjecte(){
    let atribut=document.getElementById("atributs").value;
    let objecte=document.getElementById("personas").value;
    if (atribut=="nom") {
        for(let i=0;i<persones.length;i++){
            if (persones[i].nom==objecte){
                document.body.innerHTML += `<p>El nom de la persona és ${persones[i].nom} :) </p>`;
            }

        }
    }
    else if (atribut=="cognoms") {
        for(let i=0;i<persones.length;i++){
            if (persones[i].nom==objecte){
                if(persones[i].cognoms!=undefined){
                    document.body.innerHTML += `<p>Els cognoms de ${persones[i].nom} són ${persones[i].cognoms} </p>`;
                }
                else{document.body.innerHTML+=`<p>L’atribut demanat no existeix.</p>`}
            }
        }
    }
    else if (atribut=="edat") {
        for(let i=0;i<persones.length;i++){
            if (persones[i].nom==objecte) {
                if(persones[i].edat!=undefined){
                    document.body.innerHTML += `<p>${persones[i].nom} té ${persones[i].edat} anys.</p>`;}
                else{document.body.innerHTML+=`<p>L’atribut demanat no existeix.</p>`}
            }
        }
    }
}