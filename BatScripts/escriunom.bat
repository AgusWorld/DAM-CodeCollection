@echo off
set /p nom="Escriu el teu nom: "
echo %nom%
PAUSE > nul

REM Aixo funciona correctament sempre i quan accedim a la ruta del script y l'executem desde la cmd,
REM en cas de fer-ho directament amb doble clic faria falta alguna comanda com per 
REM exemple PAUSE al final del script per tal de que la CMD no es tanqui en finalitzar l'execució.