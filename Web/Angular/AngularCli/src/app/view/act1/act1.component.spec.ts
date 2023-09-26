import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Act1Component } from './act1.component';

describe('Act1Component', () => {
  let component: Act1Component;
  let fixture: ComponentFixture<Act1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Act1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Act1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();

    component.tamany=250;
    fixture.detectChanges();
  });
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('El valor del input ha de ser el mateix que el del tamany',() => {
    fixture.componentInstance.changeSF(222);
    const compiled = fixture.debugElement.nativeElement;
    fixture.detectChanges();
    expect(compiled.querySelector('input').value).toBe("222");

    fixture.componentInstance.changeSF(41324892);
    fixture.detectChanges();
    expect(compiled.querySelector('input').value).toBe("500");


  });

  it('tamany com a minim 50 i com a maxim 500',() => {
    component.changeSF(812921);
    expect(component.tamany).toBe(500);
    component.changeSF(-12313);
    expect(component.tamany).toBe(50);
  });

  it('sumar i restar 50 a la variable tamany el executar inc() i dec()',() => {
    expect(component.tamany).toBe(250);
    component.inc();
    expect(component.tamany).toBe(300);
    component.inc();
    expect(component.tamany).toBe(350);
    component.inc();
    expect(component.tamany).toBe(400);
    component.inc();
    expect(component.tamany).toBe(450);
    component.inc();
    expect(component.tamany).toBe(500);
    component.dec();
    expect(component.tamany).toBe(450);
    component.dec();
    expect(component.tamany).toBe(400);
    component.dec();
    expect(component.tamany).toBe(350);
    component.dec();
    expect(component.tamany).toBe(300);
    component.dec();
    expect(component.tamany).toBe(250);
  });

});
