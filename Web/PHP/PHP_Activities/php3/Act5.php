<?php
$sou = $_GET["sou"];
$hisenda = $_GET["hisenda"];
$seguretat = $_GET["seguretat"];

$sou=$sou-($sou/100*$hisenda);
$sou=$sou-($sou/100*$seguretat);
print_r(json_encode($sou));