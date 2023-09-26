<?php
$array1=array(1,2,9,3); $num1=3;
$array2=array(1,2,2,3); $num2=2;
$array3=array(1,2,2,3); $num3=9;

esadins($array1,$num1);
esadins($array2,$num2);
esadins($array3,$num3);

/* ESTO LO HABIA HECHO ANTES PERO AL FINAL CREÉ UNA FUNCION
if(in_array(3,$array1)){
    echo "<h1 style='background: darkgreen; color:greenyellow; width: 144px'>bool(true)</h1>";
}
else{
    echo "<h1 style='background: darkred; color:red; width: 144px'>bool(false)</h1>";
}
if(in_array(2,$array2)){
    echo "<h1 style='background: darkgreen; color:greenyellow; width: 144px'>bool(true)</h1>";
}
else{
    echo "<h1 style='background: darkred; color:red; width: 144px'>bool(false)</h1>";
}
if(in_array(9,$array3)){
    echo "<h1 style='background: darkgreen; color:greenyellow; width: 144px'>bool(true)</h1>";
}
else{
    echo "<h1 style='background: darkred; color:red; width: 144px'>bool(false)</h1>";
}
*/

function esadins($arrayactual,$numactual){
    if (in_array($numactual,$arrayactual)){
        echo "<h1 style='background: darkgreen; color:greenyellow; width: 144px'>bool(true)</h1>";
    }
    else{
        echo "<h1 style='background: darkred; color:red; width: 144px'>bool(false)</h1>";
    }
}