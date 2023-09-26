<?php
$num=$_GET["num"];
if($num%5==0 and $num%17==0){
    print_r(json_encode(1));
}
else if($num%17==0){
    print_r(json_encode(2));
}
else if($num%5==0){
    print_r(json_encode(3));
}
else{
    print_r(json_encode(4));
}/**
 * 1 ambos  2 17    3 5     4 cap
 */