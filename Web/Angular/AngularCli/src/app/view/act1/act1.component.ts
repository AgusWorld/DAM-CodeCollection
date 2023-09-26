import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-act1',
  templateUrl: './act1.component.html',
  styleUrls: ['./act1.component.css']
})
export class Act1Component implements OnInit {
  @Input() tamany!:number;
  @Output() tamanyChange = new EventEmitter<number>()



  constructor() { }
  ngOnInit(): void {
  }

  dec() {
    this.changeS(-50);
  }
  inc() {
    this.changeS(+50);
  }

  private changeS(canvi:number){
    this.tamany=Math.min(500,Math.max(50,this.tamany+canvi))
    this.tamanyChange.emit(this.tamany)
  }


  public changeSF(size:number){
    this.tamany=Math.min(500,Math.max(50,size))
    this.tamanyChange.emit(this.tamany)
  }
}
