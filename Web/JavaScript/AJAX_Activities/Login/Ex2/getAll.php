<?php
$servername = "localhost";
$username = "root";
$password = "super3";
try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $username, $password);
    $query =$conn->prepare ("select * from users");
    $query->execute();
    $arraymia=array();
    $resultado = $query->fetchAll(PDO::FETCH_ASSOC);
    foreach($resultado as $obj) {
        foreach($obj as $key => $value) {
            if ($key=="password"){
                $dos=$value;
            }
            if($key=="nom"){
                $uno=$value;
            }

        }
        array_push($arraymia,$uno."=>".$dos);
    }
    print_r(json_encode($arraymia));


} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}