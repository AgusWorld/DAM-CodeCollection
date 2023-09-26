package AbstractFactory2;

public class AnimalFactory implements AbstractFactory<Animal> {

    @Override
    public Animal create(String animalType) {
        if ("Gat".equalsIgnoreCase(animalType)) {
            return new Gat();
        } else if ("Anec".equalsIgnoreCase(animalType)) {
            return new Anec();
        }

        return null;
    }


}
