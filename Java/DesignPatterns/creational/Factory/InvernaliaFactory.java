package Factory;

public class InvernaliaFactory implements AbstractFactory<Cotxe>{

	@Override
	public Cotxe create(Model m) {
		if(m==Model.Bifuel) {
			return new CotxeBifuelInvernalia();
		}else {
			return null;
		}
		
	}
}
