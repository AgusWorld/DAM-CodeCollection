@echo off
md Usuaris
for /L %%x in (1,1,50) do (md Usuaris\Usuari%%x)
for /L %%y in (1,1,10) do (for /L %%x in (1,1,50) do (md Usuaris\Usuari%%x\Directori%%y))
echo S'ha creat la carpeta Usuaris amb 50 Usuaris i 10 directories per a cada un d'ells.
pause>nul