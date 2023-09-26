<?php

$servername = "localhost";
$BDusername = "root";
$BDpassword = "super3";

$loginemail=$_POST["loginemail"];
$password=$_POST["password"];

$answer = array(
    "status" => "error",
    "message" => "wrong user/password",
    "alias"=>"idk"
);

try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $BDusername, $BDpassword);
    $query =$conn->prepare ("select * from users WHERE nom = '$loginemail' and password = '$password'");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);
    $alias=null;
    foreach($result as $OBJETO) {
        foreach($OBJETO as $key => $value) {
            if ($key=="alias"){
                $alias=$value;
            }
        }
        if($alias != null){
            $answer = array(
                "status" => "ok",
                "message" => $loginemail,
                "alias"=>$alias
            );

        }
    }


} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}


print_r(json_encode($answer));