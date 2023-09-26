let linea=(prompt("cadena de caracters?")).toLowerCase();
document.body.innerHTML+=`<h3>${linea}</h3>`;
function contarvocals(){
    let a=0; let e=0; let i=0; let o=0; let u=0;
    let vocals=0;
    for(x=0;x<linea.length;x++){
        if (linea.charAt(x)=='a'){a++;vocals++;}
        else if (linea.charAt(x)=='e'){e++;vocals++;}
        else if (linea.charAt(x)=='i'){i++;vocals++;}
        else if (linea.charAt(x)=='o'){o++;vocals++;}
        else if (linea.charAt(x)=='u'){u++;vocals++;}
    }
    document.body.innerHTML+=`<p>Vocals:${vocals}</p><p>As:${a} Es:${e} Is:${i} Os:${o} Us:${u}</p>`;
}
