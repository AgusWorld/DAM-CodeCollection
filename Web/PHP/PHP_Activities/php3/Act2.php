<?php
$sou=$_POST["sou"];
$hisenda=$_POST["hisenda"];
$ss=$_POST["seguretats"];


$sou=$sou-($sou/100*$hisenda);
$sou=$sou-($sou/100*$ss);
echo $sou;