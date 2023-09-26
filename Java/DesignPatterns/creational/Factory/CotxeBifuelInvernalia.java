package Factory;

public class CotxeBifuelInvernalia implements Cotxe{


	
	@Override
	public Localitzacio getLocalitzacio() {
		// TODO Auto-generated method stub
		return Localitzacio.Invernalia;
	}

	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return Model.Bifuel;
	}

	@Override
	public String toString() {
		return "CotxeBifuelInvernalia [localitzacio=" + getLocalitzacio() + ", model=" + getModel() + "]";
	}

}
