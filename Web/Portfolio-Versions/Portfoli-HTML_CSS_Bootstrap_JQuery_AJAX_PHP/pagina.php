<?php
session_start();
if (isset($_SESSION['nombredelusuario'])){
    $usuarioingresado =$_SESSION['nombredelusuario'];
    echo "<h1>Bienvenido: $usuarioingresado </h1>";
}else{
    header('location: index.php');
}
if (isset($_POST['btncerrar'])){
    session_destroy();
    header('location: index.php');
}
?>
<body>
<form method="POST">
    <input type="submit" value="Cerrar sesion" name="btncerrar"/>
    </form>
</body>