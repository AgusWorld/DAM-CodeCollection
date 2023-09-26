package Decorator;

public class Pernil extends PizzaDecorator{

	public Pernil(Pizza p) {
		super(p);
	}
	
	public String getDesc() {
		return super.getDesc()+getterDesc();
	}
	private String getterDesc() {
		return " Pernil Dolç de l'Himalaia";
	}
	public double getPreu() {
		return super.getPreu()+getterPreu();
	}
	private double getterPreu() {
		return 2.5;
	}

}
