<?php
/*Aqui asigno los valores a cada casilla de la tabla*/
for($row=1;$row<=10;$row++){
    for($col=1;$col<=10;$col++){
        $tabla[$row][$col]=$col*$row;
    }
}

/*Aqui imprimo el inicio de la tabla y asigno los estilos*/
echo "<style>table, td {
  border: 1px solid black;
  border-collapse: collapse;
}</style> 
<table>";

for($row=1;$row<=10;$row++){
    echo "<tr>";
    for($col=1;$col<=10;$col++){
        echo "<td>".$tabla[$row][$col]."</td>";
    }
    echo "</tr>";

}
echo "</table>";