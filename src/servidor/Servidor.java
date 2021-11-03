package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	private ArrayList<Socket> lista;
	
	
	public Servidor( int puerto) {
		int i = 0;
		lista = new ArrayList<Socket>();
		
		try {
			ServerSocket servidor = new ServerSocket(puerto);
			
			System.out.println("Servidor en linea . . . . ");
			
			while ( i < 100 ) {
				Socket cliente = servidor.accept();
				lista.add(cliente);
				new ServidorHilo(cliente,lista).start();
				i++;
			}
			servidor.close();
			System.out.println("El servidor se ha cerrado!");
		}catch( Exception e) {
			System.err.println("Ocurrio un error con el servidor");
		}
		
	}
	
	public static void main ( String [] args) {
		
		try {
			new Servidor(10000);
		} catch( Exception e) {
			System.err.println("Se cerro la conexion");
		}
		
	}

}
