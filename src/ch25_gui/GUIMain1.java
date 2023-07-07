package ch25_gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMain1 extends JFrame {
	
	private final String USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";
	
	private CardLayout mainCardLayout;
	
	private JPanel mainCardPanel;
	private JPanel loginPanel;
	private JPanel homePanel;
	private JTextField usernametextField;
	private JPasswordField passwordtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GUIMain1 frame = new GUIMain1();	// 해당 코드 중요
		frame.setVisible(true);				// 해당 코드 중요
	}

	/**
	 * Create the frame.
	 */
	public GUIMain1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainCardPanel = new JPanel();
		mainCardLayout = new CardLayout();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);
		
		
		loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginPanel.setLayout(null);
		mainCardPanel.add(loginPanel, "loginPanel");
		
		usernametextField = new JTextField();
		usernametextField.setBounds(131, 61, 166, 34);
		loginPanel.add(usernametextField);
		usernametextField.setColumns(10);
		
		passwordtextField = new JPasswordField();
		passwordtextField.setBounds(131, 105, 166, 34);
		loginPanel.add(passwordtextField);
		passwordtextField.setColumns(10);
		
		JButton signinBtn = new JButton("Login");
		signinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernametextField.getText();
				String password = passwordtextField.getText();
				
				if(!username.equals(USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					JOptionPane.showMessageDialog(loginPanel, "사용자 정보가 일치하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(loginPanel, "환영합니다.", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				
				mainCardLayout.show(mainCardPanel, "homePanel");
				
				
			}
				
		});
		signinBtn.setBounds(131, 149, 166, 34);
		loginPanel.add(signinBtn);
		
		homePanel = new JPanel();
		homePanel.setLayout(null);
		mainCardPanel.add(homePanel, "homePanel");
	}
	
}
