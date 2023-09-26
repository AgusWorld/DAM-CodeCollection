<?php
$nums=array(3,14,12,37);


foreach ($nums as $actual){
    if($actual%3==0 or $actual%7==0){
        $actual="true";
        echo "<h1 style='background: darkgreen; color:greenyellow; width: 150px'>bool(". $actual .")</h1>";
    }else{
        $actual="false";
        echo "<h1 style='background: darkred; color:red; width: 150px'>bool(". $actual .")</h1>";
    }
}