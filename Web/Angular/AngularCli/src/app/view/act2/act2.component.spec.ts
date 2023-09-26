import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Act2Component } from './act2.component';

describe('Act2Component', () => {
  let component: Act2Component;
  let fixture: ComponentFixture<Act2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Act2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Act2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('error suma', () => {

    component.num1="4";
    expect(component.num1).toBe("4");
    component.operacioSymbol="+";
    component.num2="8";
    expect(component.num2).toBe("8");

    component.mostrarRes();
    expect(component.resultat).toBe(12);

    expect(component).toBeTruthy();

  });


});
