<?php
$servername = "localhost";
$BDusername = "root";
$BDpassword = "super3";

$arraymagica=array();

try {
    $conn = new PDO("mysql:host=$servername;dbname=game", $BDusername, $BDpassword);
    $query =$conn->prepare ("SELECT nom FROM users ORDER BY RAND() LIMIT 1");

    $query->execute();
    $result1 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result1=$result1[0]["nom"];
    array_push($arraymagica,$result1 );

    $query->execute();
    $result2 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result2=$result2[0]["nom"];
    array_push($arraymagica,$result2 );

    $query->execute();
    $result3 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result3=$result3[0]["nom"];
    array_push($arraymagica,$result3);

    $query->execute();
    $result4 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result4=$result4[0]["nom"];
    array_push($arraymagica,$result4);

    $query->execute();
    $result5 = $query->fetchAll(PDO::FETCH_ASSOC);
    $result5=$result5[0]["nom"];
    array_push($arraymagica,$result5);


    $num1=rand(0, 1000);
    array_push($arraymagica,$num1 );
    $num2=rand(0, 1000);
    array_push($arraymagica,$num2 );
    $num3=rand(0, 1000);
    array_push($arraymagica,$num3 );
    $num4=rand(0, 1000);
    array_push($arraymagica,$num4 );
    $num5=rand(0, 1000);
    array_push($arraymagica,$num5 );


    $query = $conn->prepare("insert into partida (jugador, punts) values ((select id from users where nom='$result1' limit 1),'$num1' )");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);

    $query = $conn->prepare("insert into partida (jugador, punts) values ((select id from users where nom='$result2' limit 1),'$num2' )");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);

    $query = $conn->prepare("insert into partida (jugador, punts) values ((select id from users where nom='$result3' limit 1),'$num3' )");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);

    $query = $conn->prepare("insert into partida (jugador, punts) values ((select id from users where nom='$result4' limit 1),'$num4' )");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);

    $query = $conn->prepare("insert into partida (jugador, punts) values ((select id from users where nom='$result5' limit 1),'$num5' )");
    $query->execute();
    $result = $query->fetchAll(PDO::FETCH_ASSOC);






    print_r(json_encode($arraymagica));

} catch(PDOException $e) {
    print_r("Connection failed: " . $e->getMessage());
}