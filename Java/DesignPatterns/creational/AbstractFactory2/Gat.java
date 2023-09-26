package AbstractFactory2;

public class Gat implements Animal {

    @Override
    public String getType() {
        return "Gat";
    }

    @Override
    public String makeSound() {
        return "Marrameu";
    }


}
