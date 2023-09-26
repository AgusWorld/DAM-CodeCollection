package Decorator;

import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		DecimalFormat dformat = new DecimalFormat("#.##");
		
		Pizza pizza = new MassaFina();
		pizza = new Tomaquets(pizza);
		pizza = new OlivesVerdes(pizza);
		pizza = new Espinaques(pizza);
		System.out.println("Desc: "+pizza.getDesc());
		System.out.println("Preu: "+dformat.format(pizza.getPreu())+"$");
		pizza = new MassaClasica();
		pizza = new CarnPicada(pizza);
		pizza = new Formatge(pizza);
		pizza = new Formatge(pizza);
		pizza = new Pernil(pizza);
		System.out.println("Desc: "+pizza.getDesc());
		System.out.println("Preu: "+dformat.format(pizza.getPreu())+"$");
	}

}
