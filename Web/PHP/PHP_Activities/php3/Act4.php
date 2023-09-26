<?php
$miarray=[1,2,2,3];
$num=$_GET["num"];
if (in_array($num,$miarray)){
    print_r(json_encode(1));
}
else{
    print_r(json_encode(2));
}