package Decorator;

public class Espinaques  extends PizzaDecorator{

	public Espinaques(Pizza p) {
		super(p);
	}
	
	public String getDesc() {
		return super.getDesc()+getterDesc();
	}
	private String getterDesc() {
		return " Espinaques de marró";
	}
	public double getPreu() {
		return super.getPreu()+getterPreu();
	}
	private double getterPreu() {
		return 0.6;
	}

}
