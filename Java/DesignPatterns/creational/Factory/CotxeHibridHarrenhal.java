package Factory;

public class CotxeHibridHarrenhal implements Cotxe{

	
	
	@Override
	public Localitzacio getLocalitzacio() {
		// TODO Auto-generated method stub
		return Localitzacio.Harrenhal;
	}

	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return Model.Híbrid;
	}
	public String toString() {
		return "CotxeHibridHarrenhal [localitzacio=" + getLocalitzacio() + ", model=" + getModel() + "]";
	}

}
