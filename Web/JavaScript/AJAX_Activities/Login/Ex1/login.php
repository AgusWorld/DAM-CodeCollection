<?php
$contrasenyes = [
    "nom1@ies-sabadell.cat" => "password1",
    "nom2@ies-sabadell.cat" => "password2",
    "nom3@ies-sabadell.cat" => "password3"
];
$nom=$_POST["nom"];
$password=$_POST["password"];
$answer = array(
    "status" => "error",
    "message" => "wrong user/password"
);
foreach ($contrasenyes as $usu=>$pass){
    if ($usu==$nom and $pass==$password){
        $answer = array(
            "status" => "ok",
            "message" => $nom
        );
    }
}

print_r(json_encode($answer));