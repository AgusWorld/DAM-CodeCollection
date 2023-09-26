package Decorator2;



public class ColorLiniaDecorator extends FormaDecorator{

	Color color;
	public ColorLiniaDecorator(Forma f,Color c) {
		super(f);
		color=c;
	}

	@Override
	public void dibuixar() {
		super.dibuixar();
		System.out.println("Color de la linia: "+color);
	}

	@Override
	public void redimensionar() {
		System.out.println("Estic redimensionant");
	}

	@Override
	public String descripcion() {
		return "Color de Linea "+color;
	}

	@Override
	public boolean isOcult() {
		return false;
	}


}
