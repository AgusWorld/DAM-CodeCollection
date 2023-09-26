function getFormvalue(){
    var nom=document.getElementsByTagName("input")[0].value;
    var cognom1=document.getElementsByTagName("input")[1].value;
    var cognom2=document.getElementsByTagName("input")[2].value;
    document.getElementById("text").innerHTML+=`Nom: ${nom}&#13;Cognom1: ${cognom1}&#13;Cognom2: ${cognom2}`;
    event.preventDefault();
}