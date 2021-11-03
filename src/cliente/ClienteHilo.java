package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import ventanas.Sala;

public class ClienteHilo extends Thread{
	
	private Socket cliente;
	String mensaje;
	
	public ClienteHilo ( Socket cliente) {
		this.cliente = cliente ;
		
	}
	
	@SuppressWarnings("resource")
	public void run() {
		//String texto = "";
		try {
			while(true) {
				mensaje = new DataInputStream(cliente.getInputStream()).readUTF();
			//	texto = new DataInputStream(cliente.getInputStream()).readUTF();
			//	System.out.println(texto + "\n");
			}
			
		}catch ( Exception e ) {
			System.err.println("Se ha desconectado el cliente");
		}
	}
	
	public String recibirMensaje() {
		return this.mensaje;
	}

}
