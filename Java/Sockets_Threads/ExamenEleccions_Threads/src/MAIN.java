import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MAIN {
	static ExecutorService elExecutor = Executors.newCachedThreadPool();
	
	/* EXAMEN RECUPERACION THREADS - AGUSTIN RAMOS */
	public static void main(String[] args) {
		ArrayList<TAULA> listaDeMesas = new ArrayList<>();
		listaDeMesas.add(new TAULA('A'));
		listaDeMesas.add(new TAULA('B'));
		listaDeMesas.add(new TAULA('C'));
		
		CENTRE elCentro = new CENTRE(listaDeMesas);
		
		
		ArrayList<CIUTADA> listaCiutadans=new ArrayList<>();
		int idActual=0;
		
		/* Creeem la llista de 50 ciutadans - 15 Mesa A - 20 Mesa B - 15 Mesa C */
		for(int i=0;i<15;i++) {
			idActual++;
			listaCiutadans.add(new CIUTADA(idActual, 'A',elCentro));
		}
		for(int i=0;i<20;i++) {
			idActual++;
			listaCiutadans.add(new CIUTADA(idActual, 'B',elCentro));
		}

		for(int i=0;i<15;i++) {
			idActual++;
			listaCiutadans.add(new CIUTADA(idActual, 'C',elCentro));
		}
		
		/* Desordenem la llista per tal de que arribin al centre de forma desordenada*/
		Collections.shuffle(listaCiutadans);
		
		try {
			/* Executem tots els threads del ciutadans */
			elExecutor.invokeAll(listaCiutadans);
			
			/* Esperem a que els threads acabin y parem el programa un cop finalitzada l'execució d'aquests */
			elExecutor.awaitTermination(100, TimeUnit.MILLISECONDS);
			elExecutor.shutdown();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		


	}

}
