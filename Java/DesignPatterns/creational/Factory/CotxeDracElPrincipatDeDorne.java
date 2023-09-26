package Factory;

public class CotxeDracElPrincipatDeDorne implements Cotxe{

	
	
	@Override
	public Localitzacio getLocalitzacio() {
		// TODO Auto-generated method stub
		return Localitzacio.ElPrincipatDeDorne;
	}

	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return Model.Drac;
	}
	public String toString() {
		return "CotxeDracElPrincipatDeDorne [localitzacio=" + getLocalitzacio() + ", model=" + getModel() + "]";
	}

}
