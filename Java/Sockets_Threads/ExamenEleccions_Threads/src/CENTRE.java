import java.util.ArrayList;

public class CENTRE {
	public int capacitatMaxima = 15;

	public int personesAdins = 0;
	
	ArrayList<TAULA> listaTaules;
	
	public final Object SEMAFORO_ENTRAR_CENTRO = new Object();
	public final Object SEMAFORO_ATENDIDO_MESA = new Object();


	
	public CENTRE(ArrayList<TAULA> listaTauless) {
		this.listaTaules=listaTauless;
	}
	
	public void EntrarACentro(int id) throws InterruptedException {
        synchronized (SEMAFORO_ENTRAR_CENTRO) {
        	while (personesAdins >= capacitatMaxima) {
            	SEMAFORO_ENTRAR_CENTRO.wait();
            }
            personesAdins++;
            System.out.println("[Ciutadà #"+id+": Entrant al Centre]");
            System.out.println("[Ciutadà #"+id+": Decidint vot]");
		}
    }
	
	public void SalirDeCentro(int id) throws InterruptedException {
		synchronized (SEMAFORO_ENTRAR_CENTRO) {
			personesAdins--;
			System.out.println("[Ciutadà #"+id+": Sortint del Centre]");
			SEMAFORO_ENTRAR_CENTRO.notifyAll();
		}
    }
	
	
	public TAULA EntrarAMesa(int id, char mesaQueQuiero) throws InterruptedException{
		synchronized (SEMAFORO_ATENDIDO_MESA) {
			while(true) {
				for(TAULA mesa: listaTaules) {
					if(mesa.tipusDeMesa==mesaQueQuiero) {
						if(!mesa.ocupadoPorVotante) {
							mesa.ocupadoPorVotante=true;
							System.out.println("[Ciutadà #"+id+": Entrant a Votar a mesa: "+mesa.tipusDeMesa+"]");
							return mesa;
						}
					}
				}
				SEMAFORO_ATENDIDO_MESA.wait();
			}
		}
	}
	public void SalirDeMesa(int id, TAULA mesa) {
		synchronized (SEMAFORO_ATENDIDO_MESA) {
			mesa.ocupadoPorVotante=false;
			System.out.println("[Ciutadà #"+id+": Sortint de Votar a mesa: "+mesa.tipusDeMesa+"]");
			SEMAFORO_ATENDIDO_MESA.notifyAll();
		}
	}
	
	
	
}
