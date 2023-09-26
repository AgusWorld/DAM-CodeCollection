class Data{
    private _dia : number;
    private _mes : number;
    private _any : number;

    constructor(dia:number=1,mes:number=1,any:number=1970) {
        this._dia=dia;
        this._mes=mes;
        this._any=any;
    }

    get any(): number {
        return this._any;
    }
    public set any(value: number) {
        this._any = value;
    }

    get mes(): number {
        return this._mes;
    }
    public set mes(value: number) {
        this._mes = value;
    }

    get dia(): number {
        return this._dia;
    }
    public set dia(value: number) {
        this._dia = value;
    }

    public toString():string{
        let frase:string=("DIA/MES/ANY -> "+this._dia+"/"+this._mes+"/"+this._any);
        return frase;
    }

}

let daresult=document.getElementById("texto")  as HTMLTextAreaElement;
let lafecha:Data=new Data(1,1,1970);

let button1=document.getElementById("actualizar") as HTMLButtonElement;
button1.addEventListener("click",actualizar);
function actualizar(){
    lafecha.dia=+((<HTMLInputElement>document.getElementById("dia")).value);
    lafecha.mes=+((<HTMLInputElement>document.getElementById("mes")).value);
    lafecha.any=+((<HTMLInputElement>document.getElementById("any")).value);
}

let button2=document.getElementById("mostrar") as HTMLButtonElement;
button2.addEventListener("click",mostrar);

function mostrar(){
    daresult.innerText=lafecha.toString();
}
