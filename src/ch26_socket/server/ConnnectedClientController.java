package ch26_socket.server;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ConnnectedClientController {
	
	private static ConnnectedClientController instance;
	@Getter
	private List<ConnectedSocket> connectedSockets; // 변수 위 Getter는 해당 변수에만 Getter 적용
	
	private ConnnectedClientController() {
		connectedSockets = new ArrayList<>();
	}
	
	public static ConnnectedClientController getinstance() {
		if(instance == null) {
			instance = new ConnnectedClientController();
		}
		return instance; 
	}
}
