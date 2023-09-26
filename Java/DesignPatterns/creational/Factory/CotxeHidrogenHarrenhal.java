package Factory;

public class CotxeHidrogenHarrenhal implements Cotxe{

	
	
	@Override
	public Localitzacio getLocalitzacio() {
		// TODO Auto-generated method stub
		return Localitzacio.Harrenhal;
	}

	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return Model.Hidrogen;
	}
	public String toString() {
		return "CotxeHidrogenHarrenhal [localitzacio=" + getLocalitzacio() + ", model=" + getModel() + "]";
	}

}
