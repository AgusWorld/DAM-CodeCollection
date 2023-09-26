<?php
/*sou brut*/
$sou=2000;

/*sou descomptant 20% d'hisenda*/
$sou=$sou-($sou/100*20);

/*sou descomptant el 30% de SS un cop eliminat el 20% d'H*/
$sou=$sou-($sou/100*30);

echo $sou;