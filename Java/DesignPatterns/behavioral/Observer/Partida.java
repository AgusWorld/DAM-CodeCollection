package Observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Partida {
	String joc;
	String nick;
	int puntuacio;

	private PropertyChangeSupport support;

	
	public Partida() {
	   support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	public void setDades(String j,String n,int p) {
		this.joc=j;
		this.nick=n;
		this.puntuacio=p;
		support.firePropertyChange("Partida",false,this);
	}
	

	
}
