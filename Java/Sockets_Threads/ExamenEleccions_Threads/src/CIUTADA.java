import java.util.concurrent.Callable;

public class CIUTADA implements Callable<Boolean>{

	int id;
	char mesaLletra;
	CENTRE centro;
	TAULA mesaDondeEstoy;
	
	public CIUTADA(int id, char mesa,CENTRE centree) {
		this.id=id;
		this.mesaLletra=mesa;
		this.centro=centree;
		
	}
	
	
	@Override
	public Boolean call() throws Exception {
		centro.EntrarACentro(this.id);
		Thread.sleep(50);
		mesaDondeEstoy = centro.EntrarAMesa(this.id, this.mesaLletra);
		Thread.sleep(100);
		centro.SalirDeMesa(this.id, this.mesaDondeEstoy);
		centro.SalirDeCentro(this.id);
		return false;
	}

}
