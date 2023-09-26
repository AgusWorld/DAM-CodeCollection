var strongs=document.getElementsByTagName("Strong").length;
function highlight(){
    for(var i=0;i<strongs;i++){
        document.getElementsByTagName("strong")[i].style.fontSize = "20px";
        document.getElementsByTagName("strong")[i].style.color="lime";
    }
    document.getElementsByTagName("p")[0].style.color="white"
    document.getElementsByTagName("p")[1].style.color="white"
    document.bgColor="black";

}
function return_normal(){
    for(var i=0;i<strongs;i++){
        document.getElementsByTagName("strong")[i].style.fontSize = "12px";
        document.getElementsByTagName("strong")[i].style.color="black";
    }
    document.getElementsByTagName("p")[0].style.color="black"
    document.getElementsByTagName("p")[1].style.color="black"
    document.bgColor="white";
}
=