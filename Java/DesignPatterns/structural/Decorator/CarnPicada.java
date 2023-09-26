package Decorator;

public class CarnPicada extends PizzaDecorator{

	public CarnPicada(Pizza p) {
		super(p);
	}
	
	public String getDesc() {
		return super.getDesc()+getterDesc();
	}
	private String getterDesc() {
		return " CarnPicada de Bou";
	}
	public double getPreu() {
		return super.getPreu()+getterPreu();
	}
	private double getterPreu() {
		return 2.1;
	}

}
