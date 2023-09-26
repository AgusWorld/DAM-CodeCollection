document.documentElement.setAttribute('data-theme', 'noterrorista');
function canviEstil() {
    let casella = document.getElementById("selector").checked;
    if (casella==false){document.documentElement.setAttribute('data-theme', 'noterrorista')}
    else{document.documentElement.setAttribute('data-theme', 'terrorista')}
}