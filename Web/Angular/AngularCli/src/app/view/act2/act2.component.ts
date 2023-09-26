import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-act2',
  templateUrl: './act2.component.html',
  styleUrls: ['./act2.component.css']
})
export class Act2Component implements OnInit {
  constructor() { }
  ngOnInit(): void {}
  operacioSymbol:string="";
  num1:string="";
  num2:string="";
  operacio !: string;
  nombre !: string;
  resultat !: number;
  /**
   * onclick2
   * 1= /
   * 2= *
   * 3= +
   * 4= -
   * 5= .
   * 6= <=
   * 7= =
   * 8= clear
   */
  onclick($event: MouseEvent, pressedNumber: number) {
      if(this.operacioSymbol!=""){
        this.num2+=pressedNumber;
        this.nombre=this.num2;
      }else{
        this.num1+=pressedNumber;
        this.nombre=this.num1;
      }
      this.operacio=this.num1+this.operacioSymbol+this.num2;
  }

  mostrarRes(){
    switch (this.operacioSymbol) {
      case "/":
        this.resultat=(+this.num1)/(+this.num2);
        this.num1=""+this.resultat;
        this.num2="";
        this.nombre="";
        break;
      case "*":
        this.resultat=(+this.num1)*(+this.num2);
        this.num1=""+this.resultat;
        this.num2="";
        this.nombre="";
        break;
      case "+":
        this.resultat=(+this.num1)+(+this.num2);
        this.num1=""+this.resultat;
        this.num2="";
        this.nombre="";
        break;
      case "-":
        this.resultat=(+this.num1)-(+this.num2);
        this.num1=""+this.resultat;
        this.num2="";
        this.nombre="";
        break;
    }
  }
  onclick2($event: MouseEvent, operacioseleccionada: number) {
    switch (operacioseleccionada){
      case 1:
        this.operacioSymbol="/";
        this.operacio=this.num1+this.operacioSymbol;
        break;
      case 2:
        this.operacioSymbol="*";
        this.operacio=this.num1+this.operacioSymbol;
        break;
      case 3:
        this.operacioSymbol="+";
        this.operacio=this.num1+this.operacioSymbol;
        break;
      case 4:
        this.operacioSymbol="-";
        this.operacio=this.num1+this.operacioSymbol;
        break;
      /**
       *  case 5:
       *         this.operacioSymbol=".";
       *         break;
        */
      case 6:
        if(this.operacioSymbol!=""){
          this.num2=this.num2.slice(0,-1);
          this.nombre=this.num2;
        }else{
          this.num1=this.num1.slice(0,-1);
          this.nombre=this.num1;
        }
        this.operacio=this.num1+this.operacioSymbol+this.num2;

        break;
      case 7:
        this.mostrarRes();
        break;
      case 8:
        this.num1="";
        this.num2="";
        this.operacio="";
        this.operacioSymbol="";
        this.nombre="";
        this.resultat=0;
        break;
    }
  }
}
