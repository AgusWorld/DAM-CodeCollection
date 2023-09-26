package Factory;

public class HarrenhalFactory implements AbstractFactory<Cotxe>{

	@Override
	public Cotxe create(Model m) {
		if(m==Model.Híbrid) {
			return new CotxeHibridHarrenhal();
		}else if(m==Model.Hidrogen) {
			return new CotxeHidrogenHarrenhal();
		}else {
			return null;
		}
	}
}
