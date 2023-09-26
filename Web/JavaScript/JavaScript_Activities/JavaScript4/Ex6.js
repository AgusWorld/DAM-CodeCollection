let dies=['Dilluns','Dimarts','Dimecres','Dijous','Divendres','Dissabte','Diumenge'];
var dia=dies[new Date().getDay()-1];
var hora=new Date().getHours();
if (hora>12){hora-=12; hora+=" PM"}
else{hora+=" AM"}
var minut=new Date().getMinutes();
var segon=new Date().getSeconds();
document.body.innerHTML+=`Avui és: ${dia}<br>Hora: ${hora} : ${minut} : ${segon}`;