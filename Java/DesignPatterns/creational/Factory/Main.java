package Factory;

public class Main {

	public static void main(String[] args) {
		CotxeFactoria Factoria = new CotxeFactoria();
		
		Cotxe c1 = Factoria.getCotxe(Localitzacio.Invernalia, Model.Bifuel);
		System.out.println(c1);
		
		Cotxe c2 = Factoria.getCotxe(Localitzacio.Tempestes, Model.Cavalls);
		System.out.println(c2);
		
		Cotxe c3 = Factoria.getCotxe(Localitzacio.ElPrincipatDeDorne, Model.Drac);
		System.out.println(c3);
		
		Cotxe c4 = Factoria.getCotxe(Localitzacio.RocaCasterly, Model.Elèctric);
		System.out.println(c4);
		
		Cotxe c5 = Factoria.getCotxe(Localitzacio.Harrenhal, Model.Híbrid);
		System.out.println(c5);
		
		Cotxe c6 = Factoria.getCotxe(Localitzacio.Harrenhal, Model.Hidrogen);
		System.out.println(c6);
		
		
		

	}

}
