package Factory;

public class CotxeFactoria  {
	public static Cotxe getCotxe(Localitzacio l,Model m) {
		if(l==Localitzacio.ElPrincipatDeDorne) {
			AbstractFactory a=new ElPrincipatDeDorneFactory();
			return (Cotxe) a.create(m);
		}else if(l==Localitzacio.RocaCasterly) {
			AbstractFactory a=new RocaCasterlyFactory();
			return (Cotxe) a.create(m);
		}else if(l==Localitzacio.Tempestes) {
			AbstractFactory a=new TempestesFactory();
			return (Cotxe) a.create(m);
		}else if(l==Localitzacio.Harrenhal) {
			AbstractFactory a=new HarrenhalFactory();
			return (Cotxe) a.create(m);
		}else if(l==Localitzacio.Invernalia) {
			AbstractFactory a=new InvernaliaFactory();
			return (Cotxe) a.create(m);
		}
		
		return null;
		
	}

}
