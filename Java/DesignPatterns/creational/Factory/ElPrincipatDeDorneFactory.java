package Factory;

public class ElPrincipatDeDorneFactory implements AbstractFactory<Cotxe>{

	@Override
	public Cotxe create(Model m) {
		if(m==Model.Drac) {
			return new CotxeDracElPrincipatDeDorne();
		}else {
			return null;
		}
	}

}
