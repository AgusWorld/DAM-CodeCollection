let objectes=[
    {
        titol:  'Camí al futur',
        autor: 'Bill Gates',
        id: 1254
    },
    {
        autor: 'Walter Isaacson',
        titol: 'Steve Jobs',
        id: 4264
    },
    {
        titol: 'L’ocell de la revolta',
        autor: 'Suzanne Collins',
        id: 3245
    }
];
objectes.sort(function(un,dos) {return dos.id - un.id;});
document.body.innerHTML+=`${objectes[0].id} ${objectes[1].id} ${objectes[2].id}`;