package Adapter;

public interface Aniversari {
	int getAny();
	Mes getMes();
	int getDia();
	
	boolean isLaterThan(Aniversari altre);//any,mes i dia
	boolean isSame(Aniversari altre);//només mes i dia
	public enum Mes{
		Gener,Febrer,Març,Abril,Maig,Juny,Juliol,Agost,
		Setembre,Octubre,Novembre,Desembre;
	}
	
}
