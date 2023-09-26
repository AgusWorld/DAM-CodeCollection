package Adapter;

import java.util.GregorianCalendar;

import Adapter.Aniversari.Mes;

public class DataClassAdapterFactory implements FactoryAniversari{
	Aniversari m_a;
	
	@Override
	public Aniversari getAniversari(int year, Mes month, int day) {
		GregorianCalendar gc=new GregorianCalendar();
		switch(month) {
		case Gener:
			gc.set(year, 0, day);
			break;
		case Febrer:
			gc.set(year, 1, day);
			break;
		case Març:
			gc.set(year, 2, day);
			break;
		case Abril:
			gc.set(year, 3, day);
			break;
		case Maig:
			gc.set(year, 4, day);
			break;
		case Juny:
			gc.set(year, 5, day);
			break;
		case Juliol:
			gc.set(year, 6, day);
			break;
		case Agost:
			gc.set(year, 7, day);
			break;
		case Setembre:
			gc.set(year, 8, day);
			break;
		case Octubre:
			gc.set(year, 9, day);
			break;
		case Novembre:
			gc.set(year, 10, day);
			break;
		case Desembre:
			gc.set(year, 11, day);
			break;
		}	
		return new DataClassAdapter(gc);
	}
	
	
	
}
