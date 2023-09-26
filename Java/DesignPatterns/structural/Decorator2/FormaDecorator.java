package Decorator2;

import Decorator.Pizza;

public abstract class FormaDecorator implements Forma{
	private Forma forma;
	
	public FormaDecorator(Forma f) {
		this.forma=f;
	}
	public void dibuixar() {
		forma.dibuixar();
	}

}
