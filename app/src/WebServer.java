import java.io.*;
import java.net.*;
import java.util.*;

public final class WebServer {
	
	public static void main(String[] args) throws Exception
	{
		int port = 6789;
		ServerSocket server = new ServerSocket(port);
		
		while (true) {
			//Construir um objeto para processar a mensagem de requisição HTTP.
			Socket socket = server.accept();
			HttpRequest request = new HttpRequest(socket);
			// Criar um novo thread para processar a requisição.
			Thread thread = new Thread(request);
			//Iniciar o thread.
			thread.start();
		}
	}
}
