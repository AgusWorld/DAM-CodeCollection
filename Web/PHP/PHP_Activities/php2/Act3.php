<?php
$segons=98401;

$dies=floor($segons/86400);
$hores=floor($segons%86400/3600);
$minuts=floor($segons%86400%3600/60);
$segons=($segons%86400)%3600%60;
echo $dies."d:".$hores."h:".$minuts."m:".$segons."s";