package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import ch26_socket.simpleGUI.server.entity.Room;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	
	private Gson gson;
	private final Socket socket;
	private String username;
	
	@Override
	public void run() {
		gson = new Gson();
		
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				
				requestController(requestBody);
				
//				for(ConnectedSocket connectedSocket : SimpleGUIServer.connectedSocketList) {} // 향상된 for문
				
//				for(int i = 0; i < SimpleGUIServer.connectedSocketList.size(); i++) {} // for문
				
//				SimpleGUIServer.connectedSocketList.forEach(connetedSocket -> { // forEach문
//					try {
//						PrintWriter printWriter = 
//								new PrintWriter(connetedSocket.socket.getOutputStream(), true);
//						printWriter.println(requestBody);
//						
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					
//				});
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void requestController(String requestBody) {
		
		String resoure = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch (resoure) {
			case "connection":
				connection(requestBody);
				break;
				
			case "createRoom" :
				createRoom(requestBody);
				break;
				
			case "join" :
				join(requestBody);
				break;
		
			case "sendMessage" :
				sendMessage(requestBody);
				break;
		}
	}
	
	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto = 
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		ServerSender.getInstance().send(socket, updateRoomListRequestBodyDto);
		
	}
	
	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		Room newRoom = Room.builder()
			.roomName(roomName)
			.owner(username)
			.userList(new ArrayList<ConnectedSocket>())
			.build();
		
		SimpleGUIServer.roomList.add(newRoom);
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto = 
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		SimpleGUIServer.connectedSocketList.forEach(con -> {
			ServerSender.getInstance().send(con.socket, updateRoomListRequestBodyDto);
		});	
	}
	
	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getRoomName().equals(roomName)) {
				room.getUserList().add(this);
				
				List<String> usernameList = new ArrayList<>();
				
				//<<방 생성시 생성자 방장 표기>>
				room.getUserList().forEach(con -> {
					if(room.getOwner().equals(con.username)) {
						usernameList.add(con.username + "(방장)");
					} else {
						usernameList.add(con.username);
					}
				});
				
				room.getUserList().forEach(connectedSocket -> {
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
					
					ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
				});
			}
		});
		
	}
	
	private void sendMessage(String requestBody) {
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<RequestBodyDto<SendMessage>>() {};
		
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody();
		
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getUserList().contains(this)) { // contains = 포함
				room.getUserList().forEach(connectedsocket -> {
					RequestBodyDto<String> dto = 
							new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
					
					ServerSender.getInstance().send(connectedsocket.socket, dto);
					
				});
		}
		});
		
		
		
// 기능 추가 : 방나가기(버튼추가), 로그인시 본인 이름 표시, 방 접속시 방이름 표시, 방장표시, 방나갈시 남아있는 한명한테 방장위임 or 방폭, 더블클릭시 귓말	
		
	}
}

