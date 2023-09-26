<?php

$i=$_GET["numero"];
for($a=0;$a<=$i;$a++){
    echo "<p>".str_repeat("*",$a)."</p>";
    if ($a==$i){
        for ($i;$i+1>0;$i--){
            echo "<p>".str_repeat("*",$i)."</p>";
        }
    }
}