package com.day10.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoGui extends JFrame {
	
	private static final long serialVersionUID = 5159424749082165469L;

	private String[] controlMenuTitle = { "입력", "수정", "삭제", "전체보기", "종료" };
	private String[] inputTableTitle = { "이름", "전화번호", "주민번호", "성별", "나이", "출신지" };
	private Map<String, JButton> controlMenuButton = new HashMap<String, JButton>();
	private Map<String, JLabel> inputTableLabel = new HashMap<String, JLabel>();
	private Map<String, JTextField> inputTableTF = new HashMap<String, JTextField>();
	private JTextArea ta;
	private JPanel mainPanel;

	public InfoGui() {}

	private JPanel buildMain() {
		JPanel p = new JPanel(new BorderLayout());
		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		ta.setLineWrap(true);
		p.add(sp,BorderLayout.EAST);
		p.add(buildInputTableLeft(),BorderLayout.WEST);
		p.add(buildControlMenu(),BorderLayout.SOUTH);
		return p;
	}

	private JPanel buildControlMenu() {
		JPanel p = new JPanel(new GridLayout(1,controlMenuTitle.length));
		JButton b;
		for (int i = 0; i < controlMenuTitle.length; i++) {
			b = new JButton(
					controlMenuTitle[i],
					new ImageIcon("src\\com\\day10\\ui\\img\\"+(i+1)+".png"));
			controlMenuButton.put(controlMenuTitle[i], b);
			p.add(b);
		}
		return p;
	}

	private JPanel buildInputTableLeft() {
		int itemCnt = inputTableTitle.length;
		JPanel p = new JPanel(new GridLayout(itemCnt, 2));		
		JTextField tf;
		JLabel l;
		for (int i=0;i<itemCnt;i++) {
			l = new JLabel(inputTableTitle[i]);
			tf = new JTextField(12);			
			inputTableLabel.put(inputTableTitle[i], l);
			inputTableTF.put(inputTableTitle[i], tf);				
			p.add(l);
			p.add(tf);	
		}
		return p;
	}
	
	public void addLayout() {
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				super.windowClosed(e);
//				dispose();
//			}
//		});

		mainPanel = buildMain();
		
		add(mainPanel);
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
