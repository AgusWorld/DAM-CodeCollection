package Observer2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Xat {

	String missatgeEnviat;
	private PropertyChangeSupport support;

	public void setMissatgeEnviat(String valorNou) {
		support.firePropertyChange("missatgeEnviat", this.missatgeEnviat, valorNou);
		this.missatgeEnviat=valorNou;
	}


	public Xat() {
	   support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	

}
