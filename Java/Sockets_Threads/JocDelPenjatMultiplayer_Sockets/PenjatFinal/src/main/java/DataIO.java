import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class DataIO {

	DataInputStream datainB;
	DataOutputStream dataoutB;
	
	PrintWriter dataout;
	BufferedReader datain;

	Socket clientsocket;
	
	DataIO(Socket socket) throws IOException {
		datainB = new DataInputStream(socket.getInputStream());
		dataoutB = new DataOutputStream(socket.getOutputStream());
		dataout = new PrintWriter(socket.getOutputStream(),true);
		datain = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	DataIO (ServerSocket serversocket) throws IOException {
		
		datainB = new DataInputStream(clientsocket.getInputStream());
		dataoutB = new DataOutputStream(clientsocket.getOutputStream());
		dataout = new PrintWriter(clientsocket.getOutputStream(),true);
		datain = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
	}
	
	void close() throws IOException {
		datain.close();
		dataout.close();
	}

	//byte
	void sendB(byte message) throws IOException {
		dataoutB.writeByte(message);
		dataoutB.flush();
	}

	byte sendAndReceive(byte message) throws IOException {
		this.sendB(message);
		return this.receiveB();
	}

	void sendAndReceive(byte message, byte response) throws IOException, MyEx {
		this.sendB(message);
		this.receiveB(response);
	}

	public byte receiveB() throws IOException {
		return datainB.readByte();
	}

	void receiveB(byte message) throws IOException, MyEx {
		byte rebut = this.receiveB();
		if (rebut != message)
			throw new MyEx("----NO HE REBUT L'ESPERAT (" + message + "), SI NO -> " + rebut);

	}

	void receiveAndSendB(byte message, byte response) throws IOException, MyEx {
		this.receiveB(message);
		this.sendB(response);
	}

	//String
	void send(String message) {
		dataout.println(message);
	}

	String sendAndReceive(String message) throws IOException {
		this.send(message);
		return this.receive();
	}

	void sendAndReceive(String message, String response) throws IOException, MyEx {
		this.send(message);
		this.receive(response);
	}

	String receive() throws IOException {
		return datain.readLine();
	}

	void receive(String message) throws IOException, MyEx {
		String rebut = this.receive();
		if (rebut != message)
			throw new MyEx("----NO HE REBUT L'ESPERAT (" + message + "), SI NO -> " + rebut);
		

	}

	void receiveAndSend(String message, String response) throws IOException, MyEx {
		this.receive(message);
		this.send(response);
	}

	
}
