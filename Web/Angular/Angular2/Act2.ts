abstract class animal{


    private _especie:string;
    private _nom:string;
    private _posX:number;
    private _posY:number;
    private _url:string;


    constructor(especie:string="NoEspecie",nom:string="NoNom",posX:number=100,posY:number=100,url:string="http://cdn.onlinewebfonts.com/svg/img_546302.png") {
        this._especie=especie;
        this._nom=nom;
        this._posX=posX;
        this._posY=posY;
        this._url=url;
    }


    get nom(): string {
        return this._nom;
    }
    set nom(value: string) {
        this._nom = value;
    }
    get especie(): string {
        return this._especie;
    }
    set especie(value: string) {
        this._especie = value;
    }
    get url(): string {
        return this._url;
    }
    set url(value: string) {
        this._url = value;
    }
    get posY(): number {
        return this._posY;
    }
    set posY(value: number) {
        this._posY = value;
    }
    get posX(): number {
        return this._posX;
    }
    set posX(value: number) {
        this._posX = value;
    }

}

class Balena extends animal{

    private _aletas:number;
    private _mar:string;

    get aletas(): number {
        return this._aletas;
    }
    set aletas(value: number) {
        this._aletas = value;
    }
    get mar(): string {
        return this._mar;
    }
    set mar(value: string) {
        this._mar = value;
    }


    constructor(especie:string="NoEspecie",nom:string="NoNom",posX:number=100,posY:number=100,url:string="http://cdn.onlinewebfonts.com/svg/img_546302.png",aletas:number=2,mar:string="ATLANTIC") {
        super(especie,nom,posX,posY,url);
        this._aletas=aletas;
        this._mar=mar;
    }
    toStringFun() {
        let vari: string = "Especie: " + this.especie
            + "\nNom: " + this.nom
            + "\nX: " + this.posX
            + "\nY: " + this.posY
            + "\nAletas: " + this.aletas
            + "\nMar: " + this.mar;
        return vari;
    }

}

class Puma extends animal{

    private _potes:number;
    private _pais:string;

    constructor(especie:string="NoEspecie",nom:string="NoNom",posX:number=100,posY:number=100,url:string="http://cdn.onlinewebfonts.com/svg/img_546302.png",potes:number=4,pais:string="India") {
        super(especie,nom,posX,posY,url);
        this._potes=potes;
        this._pais=pais;
    }
    toStringFun(){
        let vari:string="Especie: "+this.especie
            +"\nNom: "+this.nom
            +"\nX: "+this.posX
            +"\nY: "+this.posY
            +"\nPotes: "+this.potes
            +"\nPais: "+this.pais;
        return vari;
    }
    get pais(): string {
        return this._pais;
    }
    set pais(value: string) {
        this._pais = value;
    }
    get potes(): number {
        return this._potes;
    }
    set potes(value: number) {
        this._potes = value;
    }

}


let balena:Balena;
let puma:Puma;

let espai1=document.getElementById("animal1") as HTMLAreaElement;
let espai2=document.getElementById("animal2") as HTMLAreaElement;

let boton=document.getElementById("selEnviar") as HTMLButtonElement;
boton.addEventListener("click",funcion);


function funcion(){
    let selEspecie:string=((<HTMLInputElement>document.getElementById("selEspecie")).value);
    let selX:number=+((<HTMLInputElement>document.getElementById("selX")).value);
    let selY:number=+((<HTMLInputElement>document.getElementById("selY")).value);
    let selURL:string=((<HTMLInputElement>document.getElementById("selURL")).value);
    let selNom:string=((<HTMLInputElement>document.getElementById("selNom")).value);


    if(selY<600 && selX<233){
        selY=600;
        selX=233;
    }

    let css:string="background-image:url("+selURL+");top:"+selY+"px;left:"+selX+"px; position:absolute; background-size: cover; width:150px;height:150px; margin:1px;"

    if (selEspecie=="Balena"){
        let selAletas:number=+((<HTMLInputElement>document.getElementById("selAletas")).value);
        balena=new Balena(selEspecie,selNom,selX,selY,selURL,selAletas);
        espai1.style.cssText=css;

    }else{
        let selPotes:number=+((<HTMLInputElement>document.getElementById("selPotes")).value);
        puma=new Puma(selEspecie,selNom,selX,selY,selURL,selPotes);
        espai2.style.cssText=css;
    }
}
let buttonToString=document.getElementById("selToString") as HTMLButtonElement;
buttonToString.addEventListener("click",imprimir);
function imprimir(){
    let selEspecie:string=((<HTMLInputElement>document.getElementById("selEspecie")).value);
    if (selEspecie=="Balena"){
        document.getElementById("selESPAI").innerText=balena.toStringFun();
    }else{
        document.getElementById("selESPAI").innerText=puma.toStringFun();
    }
}


let opcioSeleccionada=document.getElementById("selEspecie") as HTMLButtonElement;
opcioSeleccionada.addEventListener("click",dependeAnimal);
function dependeAnimal(){
    let selEspecie:string=((<HTMLInputElement>document.getElementById("selEspecie")).value);
    if(selEspecie=="Balena"){
        document.getElementById("selPotes").style.cssText="display: none;";
        document.getElementById("selAletas").style.cssText="display: ;";

        document.getElementById("selPais").style.cssText="display: none;";
        document.getElementById("selMar").style.cssText="display: ;";

    }else{
        document.getElementById("selAletas").style.cssText="display: none;";
        document.getElementById("selPotes").style.cssText="display: ;";

        document.getElementById("selMar").style.cssText="display: none;";
        document.getElementById("selPais").style.cssText="display: ;";
    }
}