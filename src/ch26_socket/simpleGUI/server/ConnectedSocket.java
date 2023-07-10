package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	
	@Getter
	private final Socket socket;
	
	
	@Override
	public void run() {
		
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = bufferedReader.readLine();
				SimpleGUIServer.connectedSocketList.forEach(con -> {
					try {
						PrintWriter printWriter = new PrintWriter(con.getSocket().getOutputStream(), true);
						printWriter.println(data);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
