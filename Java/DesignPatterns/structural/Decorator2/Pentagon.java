package Decorator2;

public class Pentagon implements Forma{

	@Override
	public void dibuixar() {
		System.out.println("Dibuixant el Pentagon");
	}

	@Override
	public void redimensionar() {
		
	}

	@Override
	public String descripcion() {
		return null;
	}

	@Override
	public boolean isOcult() {
		return false;
	}

}
