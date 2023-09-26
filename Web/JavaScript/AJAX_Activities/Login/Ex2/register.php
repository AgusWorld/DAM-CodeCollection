<?php
$servername = "localhost";
$username = "root";
$passwordd = "super3";

$nom=$_POST["nom"];

$existeya=false;
try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $username, $passwordd);
    $query =$conn->prepare ("select nom from users");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);
    foreach($result as $OBJETO) {
        foreach($OBJETO as $key => $value) {
            if ($value==$nom){
                $existeya=true;
            }
        }
    }
} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}

if(!($existeya)){
    if(str_ends_with($nom,"@ies-sabadell.cat")){
        $answer = array(
            "status" => "ok",
            "message" => $nom
        );
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

