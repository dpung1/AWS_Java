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
	

	private JPanel contentPane;
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(131, 61, 166, 34);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernametextField.getText();
				String password = passwordtextField.getText();
				
				if(!username.equals(USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					JOptionPane.showMessageDialog(contentPane, "사용자 정보가 일치하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(contentPane, "환영합니다.", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				
				contentPane.removeAll();
				setupCardLayout();
			}
		});
		btnNewButton.setBounds(131, 149, 166, 34);
		contentPane.add(btnNewButton);
		
		passwordtextField = new JPasswordField();
		passwordtextField.setBounds(131, 105, 166, 34);
		contentPane.add(passwordtextField);
		passwordtextField.setColumns(10);
	}
	
}
