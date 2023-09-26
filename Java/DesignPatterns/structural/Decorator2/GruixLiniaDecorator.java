package Decorator2;

public class GruixLiniaDecorator extends FormaDecorator{

	double gruix;
	public GruixLiniaDecorator(Forma f, double g) {
		super(f);
		this.gruix=g;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibuixar() {
		super.dibuixar();
		System.out.println("Gruix de la linia: "+gruix);
		
	}

	@Override
	public void redimensionar() {
		System.out.println("Estic redimensionant");
		
	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "El gruix de la linia es "+gruix;
	}

	@Override
	public boolean isOcult() {
		// TODO Auto-generated method stub
		return false;
	}

}
