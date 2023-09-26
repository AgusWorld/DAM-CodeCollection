<?php
$servername = "localhost";
$username = "root";
$passwordd = "super3";

$nom=$_POST["nom"];
$password=$_POST["password"];

$answer = array(
    "status" => "error",
    "message" => "wrong user/password"
);

try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $username, $passwordd);
    $query =$conn->prepare ("select * from users");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);
    foreach($result as $OBJETO) {
        $correctouser=false;
        $correctopass=false;
        foreach($OBJETO as $key => $value) {
                if ($key=="password" and $value==$password){
                    $correctopass=true;
                }
                if($key=="nom" and $value==$nom){
                    $correctouser=true;
                }
        }
        if($correctouser and $correctopass){
            $answer = array(
                "status" => "ok",
                "message" => $nom
            );
        }
    }


} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}


print_r(json_encode($answer));