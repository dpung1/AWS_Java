package ch26_socket.simpleGUI.server.entity;

import java.util.List;

import ch26_socket.simpleGUI.server.ConnectedSocket;
import lombok.Data;

@Data
public class WaitRoom {
	
	private List<ConnectedSocket> waitUserLiset;
}
