<?php
$servername = "localhost";
$BDusername = "root";
$BDpassword = "super3";

$jug1=$_POST["jugador1"];
$jug2=$_POST["jugador2"];
$points=$_POST["points"];

$arraymagica=array();


try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $BDusername, $BDpassword);





    $query =$conn->prepare ("SELECT id FROM users WHERE nom='$jug1' limit 1");
    $query->execute();
    $id1 = $query->fetchAll(PDO::FETCH_ASSOC);
    $id1=$id1[0]["id"];


    $query =$conn->prepare ("SELECT id FROM users WHERE nom='$jug2' limit 1");
    $query->execute();
    $id2 = $query->fetchAll(PDO::FETCH_ASSOC);
    $id2=$id2[0]["id"];


    $query =$conn->prepare ("SELECT idpartida FROM partida WHERE jugador='$id1' order by punts desc limit 1");
    $query->execute();
    $id1partida = $query->fetchAll(PDO::FETCH_ASSOC);
    $id1partida=$id1partida[0]["idpartida"];


    $query =$conn->prepare ("SELECT idpartida FROM partida WHERE jugador='$id2' order by punts desc limit 1");
    $query->execute();
    $id2partida = $query->fetchAll(PDO::FETCH_ASSOC);
    $id2partida=$id2partida[0]["idpartida"];






















    $query =$conn->prepare ("SELECT punts FROM partida WHERE jugador='$id1' and idpartida='$id1partida'");
    $query->execute();
    $result1 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result1=$result1[0]["punts"];
    array_push($arraymagica,$result1 );

    $pointsyarestats=$result1-$points;


    $query =$conn->prepare ("SELECT punts FROM partida WHERE jugador='$id2' and idpartida='$id2partida'");
    $query->execute();
    $result1 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result1=$result1[0]["punts"];
    array_push($arraymagica,$result1 );



    $pointsyasumats=$result1+$points;




    $query =$conn->prepare ("UPDATE partida SET  punts = '$pointsyarestats' WHERE idpartida='$id1partida'");
    $query->execute();

    $query =$conn->prepare ("UPDATE partida SET  punts = '$pointsyasumats' WHERE idpartida='$id2partida'");
    $query->execute();






    $query =$conn->prepare ("SELECT punts FROM partida WHERE jugador='$id1' and idpartida='$id1partida'");
    $query->execute();
    $result1 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result1=$result1[0]["punts"];
    array_push($arraymagica,$result1 );


    $query =$conn->prepare ("SELECT punts FROM partida WHERE jugador='$id2' and idpartida='$id2partida'");
    $query->execute();
    $result1 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result1=$result1[0]["punts"];
    array_push($arraymagica,$result1 );


    array_push($arraymagica,$id1partida );
    array_push($arraymagica,$id2partida );

    print_r(json_encode($arraymagica));

} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}