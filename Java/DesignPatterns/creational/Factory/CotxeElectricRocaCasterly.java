package Factory;

public class CotxeElectricRocaCasterly implements Cotxe{

	
	
	@Override
	public Localitzacio getLocalitzacio() {
		// TODO Auto-generated method stub
		return Localitzacio.RocaCasterly;
	}

	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return Model.Elèctric;
	}
	public String toString() {
		return "CotxeElectricRocaCasterly [localitzacio=" + getLocalitzacio() + ", model=" + getModel() + "]";
	}

}
