package ch26_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {
	
	private final Socket socket;
	
	
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		
		try {
			while(true) {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				System.out.println("이렵데이터 : " + requestBody);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
