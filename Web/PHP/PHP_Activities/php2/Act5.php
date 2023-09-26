<?php
/*a*/
$var1="i-i-r-e-f-i";

/*b*/
$var1=str_replace("i","gat",$var1);

/*c*/
$array=explode("-",$var1);

/*d*/
rsort($array);

/*e*/
$arraynova=array();
foreach ($array as $item){
    if (!str_contains($item,"a")){
        array_push($arraynova,$item);
    }
}

/*f*/
echo sizeof($arraynova);

