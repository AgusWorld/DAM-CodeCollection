for(let i=0;i<5;i++){
    let num=Math.floor(Math.random()*1025);
    document.body.innerHTML+=`<img src="https://picsum.photos/id/${num}/350/350" width="350" height="350">`
}