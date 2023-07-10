package ch26_socket.simpleGUI.client;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SimpleGUIClient extends JFrame {
	
	private String username; // 채팅하는 사람 추가
	private Socket socket;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea = new JTextArea();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = new SimpleGUIClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimpleGUIClient() {
		
		username = JOptionPane.showInputDialog(contentPane, "아이디를 입력하세요" );
		
		if(Objects.isNull(username)) {
			System.exit(0);
		}
		
		if(username.isBlank()) {
			System.exit(0);
		}
		
		try {
			socket = new Socket("127.0.0.1", 8000);
			Thread inputThread = new Thread(() -> {
				try {
					while(true) {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						textArea.append(bufferedReader.readLine() + "\n");						
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			inputThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 410, 202);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
						printWriter.println(username + " : " + textField.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		textField.setBounds(12, 222, 410, 29);
		contentPane.add(textField);
		
	}
}
