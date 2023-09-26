package Decorator2;

public class EstilLiniaDecorator extends FormaDecorator {

	TipusLinia tipus;
	public EstilLiniaDecorator(Forma f,TipusLinia t) {
		super(f);
		this.tipus=t;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dibuixar() {
		super.dibuixar();
		// TODO Auto-generated method stub
		System.out.println("Estil de la linia: "+tipus);
		
	}

	@Override
	public void redimensionar() {
		// TODO Auto-generated method stub
		System.out.println("Estic redimensionant");
		
	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		
		return "El tipus de linia es "+tipus;
	}

	@Override
	public boolean isOcult() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
