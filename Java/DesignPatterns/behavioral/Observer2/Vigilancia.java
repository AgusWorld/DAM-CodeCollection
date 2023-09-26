package Observer2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class Vigilancia implements PropertyChangeListener{
	int comptador = 0;
	String palabraProhibida;
	
	@Override
	public String toString() {
		return "Vigilancia [comptador=" + comptador + ", palabraProhibida=" + palabraProhibida + "]";
	}

	public int getComptador() {
		return comptador;
	}

	public void setComptador(int comptador) {
		this.comptador = comptador;
	}

	public String getPalabraProhibida() {
		return palabraProhibida;
	}

	public void setPalabraProhibida(String palabraProhibida) {
		this.palabraProhibida = palabraProhibida;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String p=(String)evt.getNewValue();
		if(p.toLowerCase().contains(palabraProhibida.toLowerCase())) {
			comptador++;
			System.out.println("Aquest és un traidor!! Ha dit->"+palabraProhibida);
		}
		if(comptador>=5) {
			System.out.println("Cridar a Policia Militar!! Hi ha molts traidors!!! ");
		}
	}

	public Vigilancia(String palabraProhibida) {
		super();
		this.palabraProhibida = palabraProhibida;
	}
	
	

	

}
