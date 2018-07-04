package com.day10.ui.copy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InfoGui extends JFrame {
	
	private static final long serialVersionUID = 5159424749082165469L;

	private String[] controlMenuTitle = { "입력", "수정", "삭제", "전체보기", "종료" };
	private Map<String, JButton> controlMenuButtonMap = new HashMap<String, JButton>();
	
	private String[] inputTableTitle = { "이름", "전화번호", "주민번호", "성별", "나이", "출신지" };
	private Map<String, JLabel> inputTableLabel = new HashMap<String, JLabel>();
	private Map<String, JTextField> inputTableTF = new HashMap<String, JTextField>();
	
	private String[] topMenuTitle = { "파일", "도움말"};
	private String[][] topMenuItemTitle = {{ "새파일", "열기", "저장","sep","종료"},{ "보기", "정보"}};
	private Map<String, JMenuItem> topMenuItemMap = new HashMap<String, JMenuItem>();
	
	private JTextArea ta;
	private JPanel mainPanel;

	public InfoGui() {}
	
	private JMenuItem getMenuItemByIndex(int menuIndex, int itemIndex) {
		return topMenuItemMap.get(topMenuItemTitle[menuIndex][itemIndex]);
	}
	
	private JButton getControlMenuButtonByIndex(int itemIndex) {
		return controlMenuButtonMap.get(controlMenuTitle[itemIndex]);
	}
	
	private JTextField getInputTableTextFieldByIndex(int itemIndex) {
		return inputTableTF.get(inputTableTitle[itemIndex]);
	}
	
	private JMenuItem getMenuItemByTitle(String title) {
		return topMenuItemMap.get(title);
	}
	
	private JButton getControlMenuButtonByTitle(String title) {
		return controlMenuButtonMap.get(title);
	}
	
	private JTextField getInputTableTextFieldByTitle(String title) {
		return inputTableTF.get(title);
	}
	
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
			b.setRolloverIcon(new ImageIcon("src\\com\\day10\\ui\\img\\"+(i+1)+".png"));
			b.setPressedIcon(new ImageIcon("src\\com\\day10\\ui\\img\\"+(i+1)+".png"));
			b.setToolTipText(controlMenuTitle[i]);
			b.setMnemonic((i+1));
			controlMenuButtonMap.put(controlMenuTitle[i], b);
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
			l = new JLabel(inputTableTitle[i],new ImageIcon("src\\com\\day10\\ui\\img\\수정됨_"+(i+1)+".png"),SwingConstants.LEFT);
			tf = new JTextField(12);			
			inputTableLabel.put(inputTableTitle[i], l);
			inputTableTF.put(inputTableTitle[i], tf);				
			p.add(l);
			p.add(tf);	
		}
		return p;
	}
	
	private JMenuBar buildMenuBar() {
		int menuCnt = topMenuTitle.length;		
		JMenuBar jb = new JMenuBar();
		for (int i=0;i<menuCnt;i++) {
			jb.add(buildMenu(topMenuTitle[i], i));
		}
		return jb;
	}
	
	private JMenu buildMenu(String menuTitle, int index) {
		String[] itemTitles = topMenuItemTitle[index];
		int menuItemCnt = itemTitles.length;
		JMenu jm = new JMenu(menuTitle);
		JMenuItem ji;
		for (int i=0;i<menuItemCnt;i++) {
			if(itemTitles[i].equals("sep")) {
				jm.add(new JSeparator());
			}else {
				ji = new JMenuItem(itemTitles[i]);
				topMenuItemMap.put(menuTitle, ji);
				jm.add(ji);
			}			
		}
		
		return jm;
	}
	
	public void addLayout() {
		mainPanel = buildMain();
		
		add(mainPanel);
		setJMenuBar(buildMenuBar());
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
