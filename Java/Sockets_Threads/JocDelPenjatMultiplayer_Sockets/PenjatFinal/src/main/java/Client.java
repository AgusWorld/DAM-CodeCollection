import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	static Scanner src = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost",60011);
//			Socket socket = new Socket("10.1.81.57",60009);
			DataIO chat = new DataIO(socket);
			chat.receiveB(Tweets.S_BENVINGUT);
			System.out.println("BENVINGUT");
			chat.sendB(Tweets.ACK);
			
			TriarNick(chat);
			
			// ESTAS CONECTADO CORRECTAMENTE, AHORA A VER COMO ESTA LA LOBBY
			boolean QUIEROJUGAR=true;
			while(QUIEROJUGAR) {

				Byte lobbyState=chat.receiveB();
				chat.sendB(Tweets.ACK);

				while(lobbyState!=Tweets.S_ESTAS_DINS){	
					System.out.println("PARTIDA EN CURS, ESPERANT A QUE ACABI");
					lobbyState=chat.receiveB();
					chat.sendB(Tweets.ACK);
				}
				
				if(lobbyState==Tweets.S_ESTAS_DINS)
				{
					System.out.println("T'HAS UNIT A LA LOBBY, ESPERANT L'INICI DE LA PARTIDA");
					String paraula=chat.receive();
					System.out.println("ADMIN: la palabra es "+paraula);
					chat.sendB(Tweets.ACK);
					
					chat.send(ResultatJSON(Gameplay(paraula)));
					chat.receiveB(Tweets.ACK);
					
					String ResultatsJSON=chat.receive();
					chat.sendB(Tweets.ACK);
					System.out.println(ResultatsJSON);
				}
				
				
				chat.receiveB(Tweets.S_CONTINUAR);
				chat.sendB(Tweets.ACK);
				
				System.out.println("Vols continuar jugant?? Y/N");
				String YN = src.nextLine().toUpperCase();
				if(YN.charAt(0)=='Y'){
					chat.sendB(Tweets.C_SEGUIR);
					QUIEROJUGAR=true;
				}else {
					chat.sendB(Tweets.C_PLEGAR);
					QUIEROJUGAR=false;
				}
				chat.receiveB(Tweets.ACK);
				
			}
			
			
		
			System.out.println("CLIENT ACABO EL PROGRAMA NO QUIERO JUGAR");
			chat.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	static void TriarNick(DataIO chat) throws IOException {
		System.out.println("INTRODUEIX UN NICK: ");
		
		String pickedNickname = src.nextLine();
		chat.send(pickedNickname);
		
		byte rebutNick=chat.receiveB();
		
		while(rebutNick==Tweets.S_NICK_EN_US) 
		{
			System.out.println("NICK EN ÚS, INTRODUEIX UN ALTRE: ");
			pickedNickname = src.nextLine();
			chat.send(pickedNickname);
			rebutNick=chat.receiveB();
		}
		
		System.out.println("NICK SETEJAT CORRECTAMENT: "+pickedNickname);
	}
	
	
	// FUNCION QUE CON EL OBJETO JUGADOR GENERA UNA STRING JSON
	static String ResultatJSON(Jugador player) {
		String resultatJSON="{ \"won\" : "+player.won;
		
		resultatJSON+=",\"moves\":[";
		
		for(int i=0;i<player.moves.size();i++) {
			if(i!=player.moves.size()-1) {
				resultatJSON+=" \""+player.moves.get(i)+"\" ,";
			}else {
				resultatJSON+=" \""+player.moves.get(i)+"\"";
			}
		}
		resultatJSON+="]}";
		
		return resultatJSON;
	}
	
	// DADA UNA PALABRA FINAL EJECUTA EL GAMEPLAY DEL JUEGO Y DEVUELVE UN JUGADOR CON LOS DATOS
	static Jugador Gameplay(String paraulaFinal) {
		paraulaFinal=paraulaFinal.toLowerCase();
		Jugador player = new Jugador();
		Scanner src2=new Scanner(System.in);
		boolean encurs=true;
		
		//PALABRA CIFRADA CON -
		ArrayList<Character> paraulaXifrada=new ArrayList<>();
		for(Character ch:paraulaFinal.toCharArray()) {
			paraulaXifrada.add('-');
		}
		
		
		System.out.println(paraulaXifrada+"\nIntents: "+player.nombreIntentsErronis);
		
		while(encurs) {
			
			System.out.println("Introdueix un caracter: ");
			String inputTmp = src2.nextLine().toLowerCase();
			if(inputTmp.equals(paraulaFinal)) {
				System.out.println("HAS ENDEVINAT LA PARAULA!");
				player.won=true;
				encurs=false;
				paraulaXifrada=new ArrayList<>();
				for(Character ch:paraulaFinal.toCharArray()) {
					paraulaXifrada.add(ch);
				}
				break;
			}
			
			
			String input=""+inputTmp.charAt(0);
			
			while(player.moves.contains(input.charAt(0))) {
				System.out.println("Ya has escrit aquest character, introdueix un altre: ");
				input=""+src2.nextLine().toLowerCase().charAt(0);
			}
			
			
			player.moves.add(input.charAt(0));
			player.nombreIntentsTotals++;
			
			if(!paraulaFinal.contains(input)) {
				player.nombreIntentsErronis++;
				System.out.println("La paraula NO conté la lletra "+input.charAt(0));
			}
			else if(paraulaFinal.contains(input)) {
				System.out.println("La paraula SI conté la lletra "+input.charAt(0));
				for(int x=0 ;x<paraulaFinal.length();x++) {
					if(paraulaFinal.charAt(x)==input.charAt(0)) {
						paraulaXifrada.set(x, input.charAt(0));
					}
				}
			}
			
			
			
			System.out.println(paraulaXifrada);
			System.out.println("Intents Erronis: "+player.nombreIntentsErronis);
			System.out.println("Intents Totals: "+player.nombreIntentsTotals);
			
			String palabraActual ="";
			for(Character a:paraulaXifrada) {
				palabraActual+=a;
			}
		    		
			if(palabraActual.equals(paraulaFinal)) {
				System.out.println("HAS ENDEVINAT LA PARAULA");
				player.won=true;
				encurs=false;
			}
			else if(player.nombreIntentsErronis>=10) {
				System.out.println("HAS ARRIBAT AL NUM MAXIM DE INTENTS, GO");
				player.won=false;
				encurs=false;
			}
		}
		return player;
		
		
	}
	
	
}
