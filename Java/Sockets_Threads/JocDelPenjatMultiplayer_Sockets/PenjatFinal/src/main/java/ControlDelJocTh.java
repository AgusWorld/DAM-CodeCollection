import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;



public class ControlDelJocTh implements Runnable {
	
	public Object SemaforoSeMetio = new Object();
	public boolean hihaConnectat = false;
	
	public Object SemaforoListoParaComencar = new Object();
	public Object SemaforoHayAlguienConectadoAunQueFaltaJSON = new Object();
	public Object SemaforoRecompteDisponible = new Object();
	public Object SemaforoNicknames = new Object();
	public Object SemaforoPartidaEnCurso = new Object();
	
	
	public Object SemaforoArrayDeJSONs = new Object();
	ArrayList<JSONObject> arrayDeJSONs = new ArrayList<JSONObject>();

	public Boolean llestPerComencar = false;


	public int jugadorsJugant = 0;
	public boolean partidaEnCurs = false;

	public ArrayList<String> listaNicknames = new ArrayList<String>();
	ArrayList<String> listaParaulas = new ArrayList<String>();

	String paraulaEscollida = "RES";
	public String JSONSERVER = "JSONSERVERSEFASDFDSA";

	@Override
	public void run() {
		try {
			partidaEnCurs = false;
			listaParaulas.add("UNA"); listaParaulas.add("SOL");

			while (true) {

				
				
				synchronized (SemaforoSeMetio) {
					synchronized (SemaforoPartidaEnCurso) {
						partidaEnCurs = false;
						SemaforoPartidaEnCurso.notifyAll();
					}
					SemaforoSeMetio.wait();
				}

				if (hihaConnectat) {
					System.out.println(5);
					Thread.sleep(1000);
					System.out.println(4);
					Thread.sleep(1000);
					System.out.println(3);
					Thread.sleep(1000);
					System.out.println(2);
					Thread.sleep(1000);
					System.out.println(1);
					synchronized (SemaforoPartidaEnCurso) {
						partidaEnCurs = true;
					}
					Thread.sleep(1000);
					arrayDeJSONs.clear();
					paraulaEscollida = listaParaulas.get((int) Math.floor(Math.random() * listaParaulas.size()))
							.toLowerCase();
					System.out.println("SERVER: paraula a adivinar -> " + paraulaEscollida);
					synchronized (SemaforoListoParaComencar) {
						SemaforoListoParaComencar.notifyAll();
					}

					while (jugadorsJugant > 0) {
						try {
							synchronized (this.SemaforoHayAlguienConectadoAunQueFaltaJSON) {
								this.SemaforoHayAlguienConectadoAunQueFaltaJSON.wait();
								jugadorsJugant--;
								System.out.println("1 MENOS JUGANDO");
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("YA TODOS JUGADOS");
					
					
					// METODO RECOMPTE
					synchronized (SemaforoArrayDeJSONs) {

						for (JSONObject jsonObject : arrayDeJSONs) {
							JSONArray j = jsonObject.getJSONArray("moves");

							jsonObject.put("moves", j.length());
						}
						
						
						Collections.sort(arrayDeJSONs, new Comparator<JSONObject>() {  
						    @Override  
						    public int compare(JSONObject obj1, JSONObject obj2) { 
						        int result = 0; 
						        if (obj1.getBoolean("won") && !obj2.getBoolean("won")) { 
						            result = -1; 
						        } else if (!obj1.getBoolean("won") && obj2.getBoolean("won")) { 
						            result = 1; 
						        } 
						        else { 
						            result = Integer.compare(obj1.getInt("moves"), obj2.getInt("moves")); 
						        } 
						        return result;
							} 
						}); 

					}
					System.out.println(arrayDeJSONs);
					
					
					JSONSERVER = arrayDeJSONs.toString();
					
					
					System.out.println("Enviant Recompte...Que emocion! Que emocion! TRRRRRRRRRRRRRR  TRRRRRRRRRRRRRR TRRRRRRRRRRRRRR"); Thread.sleep(1000);
					synchronized (this.SemaforoRecompteDisponible) {
						SemaforoRecompteDisponible.notifyAll();
					}
					
					//System.out.println("TODOS NOTIFICADOS");
					// Acabo la partida vamos a avisar que el boolean ha cambiado
					

				}

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
