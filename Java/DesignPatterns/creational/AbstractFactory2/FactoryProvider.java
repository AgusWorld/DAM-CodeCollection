package AbstractFactory2;

public class FactoryProvider {
	public static AbstractFactory getFactory(String choice){
        
        if("Mascota".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        
        return null;
    }
}
