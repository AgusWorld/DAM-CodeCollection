package Factory;

public class TempestesFactory implements AbstractFactory<Cotxe>{

	@Override
	public Cotxe create(Model m) {
		if(m==Model.Cavalls) {
			return new CotxeCavallsTempestes();
		}else {
			return null;
		}
	}
}
