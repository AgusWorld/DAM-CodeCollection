package Decorator;

public class Tomaquets extends PizzaDecorator{

	public Tomaquets(Pizza p) {
		super(p);
	}
	
	public String getDesc() {
		return super.getDesc()+getterDesc();
	}
	private String getterDesc() {
		return " Tomaquet tallat en fines rodaixes";
	}
	public double getPreu() {
		return super.getPreu()+getterPreu();
	}
	private double getterPreu() {
		return 1.1;
	}

}
