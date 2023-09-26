import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {
	static ExecutorService executor = Executors.newCachedThreadPool();
	public static void main(String[] args) {
		
		try {
			System.out.println("SERVER STARTED");
			ServerSocket serversocket;
			serversocket = new ServerSocket(60011);
			ControlDelJocTh controlDelJoc = new ControlDelJocTh();
			executor.submit(controlDelJoc);
			while(true) {
				System.out.println("Server waiting for client to connect");
				Socket socketClient = serversocket.accept();
				executor.submit(new ClientHandlerTh(socketClient,controlDelJoc));
				System.out.println("New client has connected");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
