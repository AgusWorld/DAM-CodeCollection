package Factory;

public class RocaCasterlyFactory implements AbstractFactory<Cotxe>{

	@Override
	public Cotxe create(Model m) {
		if(m==Model.Elèctric) {
			return new CotxeElectricRocaCasterly();
		}else {
			return null;
		}
	}
}
