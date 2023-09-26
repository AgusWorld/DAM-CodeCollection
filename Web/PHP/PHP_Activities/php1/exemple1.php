<?php
echo "<h1 style='background: fuchsia; color:yellow'>Marc ha perdido el bole detras de la pizarra</h1>";

function suma ($a,$b){
    return($a+$b);
}

echo  "<h3> LA suma és " . suma(3,4) . "!!!</h3>";



$color= array("Fucsia","Yellow","cyan");


echo "<ul>";
foreach ($color as $c){
    echo "<li>" . $c . "</li>";
}
echo "</ul>";
