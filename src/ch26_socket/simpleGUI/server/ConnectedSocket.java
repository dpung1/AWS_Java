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
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	
	
	private final Socket socket;
	private String username;
	
	@Override
	public void run() {
		
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
		Gson gson = new Gson();
		
		String resoure = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch (resoure) {
			case "join" :
				username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				
				SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
					List<String> usernameList = new ArrayList<>();
					
					SimpleGUIServer.connectedSocketList.forEach(con -> {
						usernameList.add(con.username);
						
					});
					
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
				
				break;
		
			case "sendMessage" :
			TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<RequestBodyDto<SendMessage>>() {};
			
			RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
			SendMessage sendMessage = requestBodyDto.getBody();
			
			SimpleGUIServer.connectedSocketList.forEach(connectedsocket -> {
				RequestBodyDto<String> dto = 
						new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
				
				ServerSender.getInstance().send(connectedsocket.socket, dto);
				
			});
			
			break;
		}
	}
}
