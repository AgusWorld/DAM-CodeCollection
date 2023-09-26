<?php
$servername = "localhost";
$DBusername = "root";
$DBpassword = "super3";
$nombre="";
$nombre=$_POST["nombre"];
try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $DBusername, $DBpassword);
    if($nombre!=""){
        $query =$conn->prepare ("select idpartida,alias,punts from partida join users on users.id = partida.jugador where nom='$nombre' order by punts desc, alias asc,idpartida asc ");
    }else{
        $query =$conn->prepare ("select idpartida,alias,punts from partida join users on users.id = partida.jugador order by punts desc, alias asc,idpartida asc");
    }
    $query->execute();
    $arraymia=array();
    $resultado = $query->fetchAll(PDO::FETCH_ASSOC);

    print_r(json_encode($resultado));


} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}