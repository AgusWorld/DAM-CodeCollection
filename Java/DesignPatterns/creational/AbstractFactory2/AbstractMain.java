package AbstractFactory2;

public class AbstractMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory abstractFactory;
        
        //creating a brown toy dog
        abstractFactory = FactoryProvider.getFactory("Mascota");
        Animal toy =(Animal) abstractFactory.create("Gat");
        
        abstractFactory = FactoryProvider.getFactory("Color");
        Color color =(Color) abstractFactory.create("HotPink");
        
        String result = "Un " + toy.getType() + " amb " + color.getColor() + " color " + toy.makeSound();
        
        System.out.println(result);
	}

}
