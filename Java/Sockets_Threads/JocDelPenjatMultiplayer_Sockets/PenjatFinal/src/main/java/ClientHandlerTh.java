import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONObject;



public class ClientHandlerTh implements Runnable{
	
	ControlDelJocTh controlDelJoc;
	Socket socketClient;
	DataIO chat;
	String nickname;
	
	
	
	public ClientHandlerTh(Socket socketClient,ControlDelJocTh controlDelJoc) throws IOException {
		this.socketClient=socketClient;
		this.chat = new DataIO(socketClient);
		this.controlDelJoc = controlDelJoc;
	}
	@Override
	public void run() {
		try {
			chat.sendB(Tweets.S_BENVINGUT);
			chat.receiveB(Tweets.ACK);
			
			System.out.println(socketClient.getInetAddress()+" IS PICKING NICK");
			nickname=chat.receive();
			System.out.println(controlDelJoc.listaNicknames);
			while(controlDelJoc.listaNicknames.contains(nickname)) {
				chat.sendB(Tweets.S_NICK_EN_US);
				nickname=chat.receive();
			}
			chat.sendB(Tweets.ACK);
			synchronized (controlDelJoc.SemaforoNicknames) {
				controlDelJoc.listaNicknames.add(nickname);
			}
			System.out.println(socketClient.getInetAddress()+" NAME SETTED CORRECTLY TO "+nickname);
			
			
			while(true) {
				synchronized (controlDelJoc.SemaforoSeMetio) {
					controlDelJoc.hihaConnectat=true;
				}
				
				
				
				//Si hay partida en curso hago un wait a que acabe
				synchronized (controlDelJoc.SemaforoPartidaEnCurso) {
					while(controlDelJoc.partidaEnCurs) {
						chat.sendB(Tweets.S_EN_CURS);
						chat.receiveB(Tweets.ACK);
						controlDelJoc.SemaforoPartidaEnCurso.wait();
					}
				}
				
				
				//Si no hay en curso me meto
				
				synchronized (controlDelJoc.SemaforoSeMetio) {
					controlDelJoc.SemaforoSeMetio.notify();
				}
				chat.sendB(Tweets.S_ESTAS_DINS);
				chat.receiveB(Tweets.ACK);
				
				synchronized (controlDelJoc.SemaforoHayAlguienConectadoAunQueFaltaJSON) {
					controlDelJoc.jugadorsJugant++;
				}
				//ESPERA A QUE EL JOC DIGA QUE ESTAMOS LISTOS PARA COMENZAR
				synchronized (controlDelJoc.SemaforoListoParaComencar) {
					controlDelJoc.SemaforoListoParaComencar.wait();
				}
				
				chat.send(controlDelJoc.paraulaEscollida);
				chat.receiveB(Tweets.ACK);
				
				String resultatJSON=chat.receive();
				chat.sendB(Tweets.ACK);

				JSONObject myOBJ = new JSONObject(resultatJSON);
				myOBJ.put("name", this.nickname);
//				System.out.println(myOBJ.get("won"));
//				System.out.println(myOBJ.get("moves"));
//				System.out.println(myOBJ.get("name"));
				synchronized (controlDelJoc.SemaforoArrayDeJSONs) {
					controlDelJoc.arrayDeJSONs.add(myOBJ);
				}
				synchronized (controlDelJoc.SemaforoHayAlguienConectadoAunQueFaltaJSON) {
					controlDelJoc.SemaforoHayAlguienConectadoAunQueFaltaJSON.notify();
					System.out.println("YO YA HE NOTIFICADO MI ENVIO DE RESULTADO");
				}
				synchronized (controlDelJoc.SemaforoRecompteDisponible) {
					System.out.println("AHORA ESPERO EL RECOMPTE");
					controlDelJoc.SemaforoRecompteDisponible.wait();
				}
				
				
				
				System.out.println("EL RECOMPTE YA ESTA");
				chat.send(controlDelJoc.JSONSERVER);
				chat.receiveB(Tweets.ACK);
				
				chat.sendB(Tweets.S_CONTINUAR);
				chat.receiveB(Tweets.ACK);
				
				byte queVolFer=chat.receiveB();
				
				chat.sendB(Tweets.ACK);
				
			}
			
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyEx e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
