package cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
	
	private Socket cliente;
	private String mensaje;
	ClienteHilo ch ;
	
	public Cliente ( int puerto , String ip) {
		try {
			cliente = new Socket(ip,puerto);
			ch = new ClienteHilo(cliente);
			ch.start();
		}catch( IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribe(String texto) throws IOException {
		InetAddress address = InetAddress.getLocalHost();
		String ip = address.getHostAddress();
		//InputStreamReader leer = new InputStreamReader(System.in);
		//BufferedReader buffer = new BufferedReader(leer);
		//System.out.println(">: ");
		//texto = buffer.readLine();
		//while(!texto.equals("Salir")) {
		new DataOutputStream(cliente.getOutputStream()).writeUTF(ip + ":" + texto);
			//System.out.println(">: ");
			//texto = buffer.readLine();
		//}
		//cliente.close();
	}
	
	public String enviarMensajeHilo() {
		return this.ch.recibirMensaje();
	}
	
	public void close() throws IOException {
		cliente.close();
	}
	
	/*public static void main( String[] args) {
		try {
			new Cliente(10000,"localhost").escribe();
		} catch( Exception e) {
			System.err.println("Se cerro la conexion");
		}
	}*/
	

}
