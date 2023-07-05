package ch25_gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIMain2 extends JFrame {
	
	private JPanel mainCardPane;
	private CardLayout maincardLayout;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain2 frame = new GUIMain2();
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
	public GUIMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/* <<< mainCardPane >>> */
		mainCardPane = new JPanel();
		maincardLayout = new CardLayout(0, 0);
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 테두리
		mainCardPane.setLayout(maincardLayout);
		
		setContentPane(mainCardPane);
		
		/* <<< subPanel1 >>> */
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);
		
		JButton subPannel2ShowBtn = new JButton("2번 페이지");
		subPannel2ShowBtn.setBounds(315, 117, 97, 23);
		subPanel1.add(subPannel2ShowBtn);
		
		subPannel2ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel2");
			}
		});
		
		/* <<< subPanel2 >>> */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		JButton subPannel1ShowBtn = new JButton("1번 페이지");
		subPannel1ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel1");
			}
		});
		subPannel1ShowBtn.setBounds(12, 117, 97, 23);
		subPanel2.add(subPannel1ShowBtn);
		
		JButton subPannel3ShowBtn = new JButton("3번 페이지");
		subPannel3ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel3");
			}
		});
		subPannel3ShowBtn.setBounds(315, 117, 97, 23);
		subPanel2.add(subPannel3ShowBtn);
		
		/* <<< subPanel3 >>> */
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);
		
		JButton subPannel2ShowBtn2 = new JButton("2번 페이지");
		subPannel2ShowBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincardLayout.show(mainCardPane, "subPanel2");
			}
		});
		subPannel2ShowBtn2.setBounds(12, 116, 97, 23);
		subPanel3.add(subPannel2ShowBtn2);
		
	}

}
