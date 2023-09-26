package Decorator2;

public class ColorEmplenamentDecorator extends FormaDecorator{

	Color color;
	public ColorEmplenamentDecorator(Forma f,Color c) {
		super(f);
		this.color=c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibuixar() {
		super.dibuixar();
		System.out.println("Color d'emplenament: "+color);
	}

	@Override
	public void redimensionar() {
		// TODO Auto-generated method stub
		System.out.println("Estic redimensionant");
		
	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "Color d'emplenament "+color;
	}

	@Override
	public boolean isOcult() {
		// TODO Auto-generated method stub
		return false;
	}

}
