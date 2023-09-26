package Decorator;

public class Formatge extends PizzaDecorator{

	public Formatge(Pizza p) {
		super(p);
	}
	
	public String getDesc() {
		return super.getDesc()+getterDesc();
	}
	private String getterDesc() {
		return " Mix latino de Formatge";
	}
	public double getPreu() {
		return super.getPreu()+getterPreu();
	}
	private double getterPreu() {
		return 1.5;
	}

}
