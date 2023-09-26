<?php
$contrasenyes = [
    "nom1@ies-sabadell.cat" => "password1",
    "nom2@ies-sabadell.cat" => "password2",
    "nom3@ies-sabadell.cat" => "password3"
];
$nom=$_POST["nom"];
$password=$_POST["password"];

if(!array_key_exists($nom,$contrasenyes)){
    if(str_ends_with($nom,"@ies-sabadell.cat")){
        $answer = array(
            "status" => "ok",
            "message" => $nom
        );
        array_push($contrasenyes,($nom."=>".$password));
    }else {
        $answer = array(
            "status" => "error",
            "message" => "wrong email"
        );
    }
}else {
    $answer = array(
        "status" => "error",
        "message" => "User exists"
    );
}
print_r(json_encode($answer));

