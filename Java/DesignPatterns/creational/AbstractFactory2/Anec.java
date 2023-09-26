package AbstractFactory2;

public class Anec implements Animal {

    @Override
    public String getType() {
        return "Anec";
    }

    @Override
    public String makeSound() {
        return "Nyec-nyec";
    }


}
