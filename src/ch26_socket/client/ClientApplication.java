package ch26_socket.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApplication extends JFrame {
	
	private Socket socket;

	private JPanel mainPanel;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JTextField messageTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplication frame = new ClientApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 414);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		
		// <<< 채팅내용 >>>
		JScrollPane chatTextAreaScrollPane = new JScrollPane();
		chatTextAreaScrollPane.setBounds(12, 10, 267, 307);
		mainPanel.add(chatTextAreaScrollPane);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setEditable(false); // 채팅 비활성
		chatTextAreaScrollPane.setViewportView(chatTextArea);
		
		
		// <<< 채팅연결 >>>
		ipTextField = new JTextField();
		ipTextField.setBounds(291, 13, 131, 21);
		mainPanel.add(ipTextField);
		ipTextField.setColumns(10);
		
		portTextField = new JTextField();
		portTextField.setBounds(291, 44, 131, 21);
		mainPanel.add(portTextField);
		portTextField.setColumns(10);
		
		JButton connectionButton = new JButton("접속");
		connectionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String serverIp = ipTextField.getText();
				String serverPort = portTextField.getText();
				
				if(serverIp.isBlank() || serverPort.isBlank()) {
					JOptionPane.showMessageDialog(mainPanel, "IP와 PORT번호를 입력해주세요.", "접속오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					socket = new Socket(serverIp, Integer.parseInt(serverPort));
					
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		connectionButton.setBounds(291, 75, 131, 23);
		mainPanel.add(connectionButton);
		
		
		// <<< 접속자 >>>
		JScrollPane connectedUserListScrollPane = new JScrollPane();
		connectedUserListScrollPane.setBounds(291, 107, 131, 210);
		mainPanel.add(connectedUserListScrollPane);
		
		JList connectedUserList = new JList();
		connectedUserListScrollPane.setViewportView(connectedUserList);
		
		
		// <<< 메세지입력 및 전송 >>>
		messageTextField = new JTextField();
		messageTextField.setBounds(12, 327, 335, 38);
		messageTextField.setEditable(false); // 채팅 비활성
		mainPanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		JButton messageSendButton = new JButton("전송");
		messageSendButton.setBounds(359, 327, 63, 38);
		messageSendButton.setEnabled(false); // 전송버튼 비활성
		mainPanel.add(messageSendButton);
	}
}
