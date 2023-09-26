function funcio1(){
    let num1=parseInt(prompt("Numero 1??"));
    let num2=parseInt(prompt("Numero 2??"));
    let total=num1+num2
    if (num1+num2==50 || num1==50 || num2==50){
        document.body.innerHTML+=`<h2>Cert: ${num1}+${num2}=${total}</h2>`;
    }
    else{
        document.body.innerHTML+=`<h2>Fals ${num1}+${num2}=${total}</h2>`;
    }
}