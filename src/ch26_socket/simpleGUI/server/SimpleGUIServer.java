package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ch26_socket.simpleGUI.server.entity.Room;

public class SimpleGUIServer {
	
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	public static List<Room> roomList = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket  = new ServerSocket(8000);
			System.out.println("[ 서버실행 ]");
			
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("접속");
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocketList.add(connectedSocket);
				connectedSocket.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
