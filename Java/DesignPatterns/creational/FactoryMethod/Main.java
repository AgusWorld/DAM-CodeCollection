package FactoryMethod;

public class Main {

	public static void main(String[] args) {
		TargetaFactory BBVA = new TargetaFactory();
		
		Client c1 = new Client("Alberto", 600);
		Client c2 = new Client("Raul", 333);
		Client c3 = new Client("Eloi", 0);
		
		c1.setTargeta(BBVA.getTargeta(c1));
		System.out.println(c1+"\n-----------------------------------");
		c2.setTargeta(BBVA.getTargeta(c2));
		System.out.println(c2+"\n-----------------------------------");
		c3.setTargeta(BBVA.getTargeta(c3));
		System.out.println(c3+"\n-----------------------------------");
		c1.setTargeta(BBVA.getTargeta(c1));

	}

}
