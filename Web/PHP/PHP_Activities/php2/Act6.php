<?php
/*a*/
$variable=21;

/*b $mybool sera 1(true) si es divisible*/
$mybool=$variable%3==0;
if($mybool){
    echo "Divisible entre 3<br>";
}else{
    echo "No divisible entre 3<br>";
}
/*c*/
$variable=$variable*15;
echo "Multiplicat per 15: ".$variable."<br>";

/*d*/
for ($cen=0;$cen<100;$cen++){
    $variable++;
}
echo "Afegit 100 vegades 1: ".$variable."<br>";

/*e*/
$variable=floor(sqrt($variable));
echo "Arrel quadrada sense decimal: ".$variable."<br>";

/*f*/
$variable=strval($variable);
echo substr_replace($variable,"codi",strlen($variable)-1,0);
