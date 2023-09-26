document.body.innerHTML+="<ul id=\"lista\"></ul>"
let vegades=0;
for(let i=0;i<10;i++){
    let random=Math.floor(Math.random()*11)
    if (random==5){vegades++;}
    document.getElementById("lista").innerHTML+="<li>"+random+"</li>"
}
document.body.innerHTML+="El nombre 5 ha sortit "+vegades+" vegades en 10 tirades"