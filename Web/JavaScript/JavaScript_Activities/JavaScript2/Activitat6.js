for(let i=1;i<=10;i++){
    document.body.innerHTML+=`<p id="${i}">Text número ${i}</p>`
    let color=Math.floor(Math.random()*256)
    let color2=Math.floor(Math.random()*256)
    let color3=Math.floor(Math.random()*256)
    document.getElementById(`${i}`).style.backgroundColor= `rgb(${color},${color2},${color3})`;
}