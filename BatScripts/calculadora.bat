@echo off
echo  ----------------------
echo  Calculadora Quantica
echo  ----------------------
echo.

echo  Introdueix l'operacio a fer:  + o - o * o / 
set /p ope=
echo    Introdueix el primer numero:
set/p num1=
echo    Introdueix el segon numero:
set/p num2=
If %ope%==+ set /a resultat=%num1%+%num2%
If %ope%==- set /a resultat=%num1%-%num2%
If %ope%==* set /a resultat=%num1%*%num2%
If %ope%==/ set /a resultat=%num1%/%num2%
echo.
echo   Resultat: %num1% %ope% %num2% = %resultat%
pause>nul