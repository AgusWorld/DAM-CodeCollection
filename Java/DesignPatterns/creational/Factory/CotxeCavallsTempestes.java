package Factory;

public class CotxeCavallsTempestes implements Cotxe{

	
	
	@Override
	public Localitzacio getLocalitzacio() {
		// TODO Auto-generated method stub
		return Localitzacio.Tempestes;
	}

	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return Model.Cavalls;
	}
	public String toString() {
		return "CotxeCavallsTempestes [localitzacio=" + getLocalitzacio() + ", model=" + getModel() + "]";
	}

}
