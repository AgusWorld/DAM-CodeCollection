package Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Videojoc implements PropertyChangeListener{
	String nom;
	String nickRecord;
	int Record;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNickRecord() {
		return nickRecord;
	}
	public void setNickRecord(String nickRecord) {
		this.nickRecord = nickRecord;
	}
	public int getRecord() {
		return Record;
	}
	public void setRecord(int record) {
		Record = record;
	}
	
	public Videojoc(String nom, String nickRecord, int record) {
		super();
		this.nom = nom;
		this.nickRecord = nickRecord;
		Record = record;
	}
	public Videojoc(String nom) {
		super();
		this.nom = nom;
		this.Record=0;
	}

	
	
	public void propertyChange(PropertyChangeEvent evt) {
		Partida p=(Partida)evt.getNewValue();
		if(p.puntuacio>this.getRecord() && p.joc.equals(this.getNom())) {
			this.setNickRecord(p.nick);
			this.setRecord(p.puntuacio);
		}
	}
	@Override
	public String toString() {
		return "Videojoc [nom=" + nom + ", nickRecord=" + nickRecord + ", Record=" + Record + "]";
	}
	
	
	
	
	
	
}