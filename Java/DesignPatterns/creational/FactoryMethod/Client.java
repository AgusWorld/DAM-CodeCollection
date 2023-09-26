package FactoryMethod;

public class Client {
	String Nom;
	float Salari;
	Targeta Targeta;
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public float getSalari() {
		return Salari;
	}
	public void setSalari(float salari) {
		Salari = salari;
	}
	public Targeta getTargeta() {
		return Targeta;
	}
	public void setTargeta(Targeta targeta) {
		Targeta = targeta;
	}
	@Override
	public String toString() {
		return "Client [Nom=" + Nom + ", Salari=" + Salari + ", Targeta=" + Targeta + "]";
	}
	public Client(String nom, float salari) {
		super();
		Nom = nom;
		Salari = salari;
	}
	
	
}
