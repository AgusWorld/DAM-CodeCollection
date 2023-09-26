package Decorator;

public class OlivesVerdes extends PizzaDecorator{

	public OlivesVerdes(Pizza p) {
		super(p);
	}
	
	public String getDesc() {
		return super.getDesc()+getterDesc();
	}
	private String getterDesc() {
		return " Olives de color verd com l'aigua";
	}
	public double getPreu() {
		return super.getPreu()+getterPreu();
	}
	private double getterPreu() {
		return 0.9;
	}

}
