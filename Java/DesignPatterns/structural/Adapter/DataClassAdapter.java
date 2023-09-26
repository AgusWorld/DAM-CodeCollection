package Adapter;

import java.util.GregorianCalendar;

public class DataClassAdapter implements Aniversari{
	GregorianCalendar calendar;

	public DataClassAdapter(GregorianCalendar grandchampion) {
		this.calendar=grandchampion;
	}

	@Override
	public int getAny() {
		return calendar.get(1);
	}

	@Override
	public Mes getMes() {
		switch(calendar.get(2)){
		case 0:
			return Mes.Gener;
		case 1:
			return Mes.Febrer;
		case 2:
			return Mes.Març;
		case 3:
			return Mes.Abril;
		case 4:
			return Mes.Maig;
		case 5:
			return Mes.Juny;
		case 6:
			return Mes.Juliol;
		case 7:
			return Mes.Agost;
		case 8:
			return Mes.Setembre;
		case 9:
			return Mes.Octubre;
		case 10:
			return Mes.Novembre;
		case 11:
			return Mes.Desembre;
		default:
			return null;
		}
		
	}
	

	@Override
	public int getDia() {
		return calendar.get(calendar.DATE);
	}

	@Override
	public boolean isLaterThan(Aniversari altre) {
		return this.calendar.after(new GregorianCalendar(altre.getAny(),transMes(altre.getMes()),altre.getDia()));
	}

	@Override
	public boolean isSame(Aniversari altre) {
		
		if(this.getDia()==altre.getDia() 
				&& this.getMes()==altre.getMes()) {
			return true;
		}else {
			return false;
		}	
		
	}
	
	public int transMes(Mes month) {
		switch(month) {
		case Gener:
			return 1;
		case Febrer:
			return 2;
		case Març:
			return 3;
		case Abril:
			return 4;
		case Maig:
			return 5;
		case Juny:
			return 6;
		case Juliol:
			return 7;
		case Agost:
			return 8;
		case Setembre:
			return 9;
		case Octubre:
			return 10;
		case Novembre:
			return 11;
		case Desembre:
			return 12;
		default:
			return 0;
		}	
		
		
	}

	@Override
	public String toString() {
		return " " + getAny() + "/" + transMes(getMes())
				+ "/" + getDia() + " ";
	}

	
	

	

}
