<?php
$servername = "localhost";
$BDusername = "root";
$BDpassword = "super3";

$registeremail=$_POST["regemail"];
$registeralias=$_POST["regalias"];
$registerpassword=$_POST["regpassword"];


$existeya=false;
try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $BDusername, $BDpassword);
    $query =$conn->prepare ("select nom from users");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);
    foreach($result as $OBJETO) {
        foreach($OBJETO as $key => $value) {
            if ($value==$registeremail){
                $existeya=true;
            }
        }
    }


if(!($existeya)){

    if(str_ends_with($registeremail,"@ies-sabadell.cat")){
        $answer = array(
            "status" => "ok",
            "message" => $registeremail
        );


        $query = $conn->prepare("insert into users (nom, alias, password) values (:name, :alias, :password)");
        $query->bindParam("name", $registeremail, PDO::PARAM_STR);
        $query->bindParam("password", $registerpassword, PDO::PARAM_STR);
        $query->bindParam("alias", $registeralias, PDO::PARAM_STR);

        $resultinsert = $query->execute();
        $result = $query->fetch(PDO::FETCH_ASSOC);



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
} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}