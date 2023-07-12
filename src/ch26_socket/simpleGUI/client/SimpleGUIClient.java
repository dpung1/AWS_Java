package ch26_socket.simpleGUI.client;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.Getter;

@Getter
public class SimpleGUIClient extends JFrame {
	
	private static SimpleGUIClient instance;
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}
	
	private String username; // 채팅하는 사람 추가
	private Socket socket;
	
	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;
	
	private JPanel chattingRoomListPanel;
	private JScrollPane roomListScrollPane;
	private DefaultListModel<String> roomListModel;
	private JList roomList;
	
	private JPanel chattingRoomPane;
	private JTextField messageTextField;
	private JTextArea chattingTextArea;
	
	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel;
	private JList userList;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = SimpleGUIClient.getInstance();
					frame.setVisible(true);
					
					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start();
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimpleGUIClient() {
		
		username = JOptionPane.showInputDialog(chattingRoomPane, "아이디를 입력하세요" );
		
		if(Objects.isNull(username)) {
			System.exit(0);
		}
		
		if(username.isBlank()) {
			System.exit(0);
		}
		
		try {
			socket = new Socket("127.0.0.1", 8000);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		chattingRoomListPanel = new JPanel();
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		chattingRoomListPanel.setLayout(null);
		
		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(12, 10, 100, 40);
		createRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방제목을 입력하세요.");
				if(Objects.isNull(roomName)) {
					return;
				}
				if(roomName.isBlank()) {
					JOptionPane.showMessageDialog(chattingRoomListPanel, "방제목을 입력하세요.", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(int i = 0; i < roomListModel.size(); i++) {
					if(roomListModel.get(i).equals(roomName)) {
						JOptionPane.showMessageDialog(chattingRoomListPanel, "이미 존재하는 방제목입니다.", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				ClientSender.getInstance().send(requestBodyDto);
			}
		});
		chattingRoomListPanel.add(createRoomButton);
		
		
		roomListScrollPane = new JScrollPane();
		roomListScrollPane.setBounds(12, 60, 410, 191);
		chattingRoomListPanel.add(roomListScrollPane);
		
		roomListModel = new DefaultListModel<String>();
		roomList = new JList(roomListModel);
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					String roomName = roomListModel.get(roomList.getSelectedIndex());
					mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
					RequestBodyDto<String> requestBodyDto
					= new RequestBodyDto<String>("join", roomName);
					ClientSender.getInstance().send(requestBodyDto);
				}
			}
		});
		roomListScrollPane.setViewportView(roomList);
		
		
		chattingRoomPane = new JPanel();
		chattingRoomPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomPane.setLayout(null);
		mainCardPanel.add(chattingRoomPane, "chattingRoomPanel");
		
		
		JScrollPane chattingTextAreaScrollPanel = new JScrollPane();
		chattingTextAreaScrollPanel.setBounds(12, 10, 277, 202);
		chattingRoomPane.add(chattingTextAreaScrollPanel);
		
		chattingTextArea = new JTextArea();
		chattingTextAreaScrollPanel.setViewportView(chattingTextArea);
		
		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(messageTextField.getText())
							.build();
					
					RequestBodyDto<SendMessage> requestBodyDto = 
							new RequestBodyDto<>("sendMessage", sendMessage);
					
					ClientSender.getInstance().send(requestBodyDto);
					messageTextField.setText("");
				}
			}
		});
		messageTextField.setBounds(12, 222, 410, 29);
		chattingRoomPane.add(messageTextField);
		
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(301, 10, 121, 202);
		chattingRoomPane.add(userListScrollPane);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScrollPane.setViewportView(userList);
		
		
	}
}
