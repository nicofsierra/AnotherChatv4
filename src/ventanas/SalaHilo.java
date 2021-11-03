package ventanas;

import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import cliente.Cliente;

public class SalaHilo extends Thread {
	private Socket cliente;
	String mensaje;
	JTextArea textArea;

	public SalaHilo(Cliente cliente2, JTextArea textArea) {
		this.cliente = cliente;
		this.textArea = textArea;
	}

	@Override
	@SuppressWarnings("resource")
	public void run() {
		String texto = "";
		try {
			while (true) {
				texto = new DataInputStream(cliente.getInputStream()).readUTF();
				textArea.append(texto);
			}

		} catch (Exception e) {
			System.err.println("Se ha desconectado el cliente");
		}
	}
}