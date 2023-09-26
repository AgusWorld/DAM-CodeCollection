package Decorator;

public abstract class PizzaDecorator implements Pizza{
	private Pizza pizza;
	
	
	public PizzaDecorator(Pizza p) {
		this.pizza=p;
	}
	public String getDesc() {
		return pizza.getDesc();
	}
	public double getPreu() {
		return pizza.getPreu();
	}
	
	
}
