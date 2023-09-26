package AbstractFactory2;

public class ColorFactory implements AbstractFactory<Color> {

    @Override
    public Color create(String colorType) {
        if ("HotPink".equalsIgnoreCase(colorType)) {
            return new HotPink();
        } else if ("Aqua".equalsIgnoreCase(colorType)) {
            return new Aqua();
        }

        return null;
    }

}
