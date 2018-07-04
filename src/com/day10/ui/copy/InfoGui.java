package com.day10.ui.copy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

	private String[] topMenuTitle = { "파일", "도움말" };
	private String[][] topMenuItemTitle = { { "새파일", "열기", "저장", "sep", "종료" }, { "보기", "정보" } };
	private Map<String, JMenuItem> topMenuItemMap = new HashMap<String, JMenuItem>();

	private JTextArea ta;
	private JPanel mainPanel;

	public InfoGui() {
	}

	private JMenuItem getMenuItemFromTopMenuByIndex(int menuIndex, int itemIndex) {
		return getMenuItemFromTopMenuByTitle(topMenuItemTitle[menuIndex][itemIndex]);
	}

	private JButton getButtonFromeControlMenuByIndex(int itemIndex) {
		return getButtonFromeControlMenuByTitle(controlMenuTitle[itemIndex]);
	}

	private JTextField getTextFieldFromeInputTableByIndex(int itemIndex) {
		return getTextFieldFromeInputTableByTitle(inputTableTitle[itemIndex]);
	}

	private JMenuItem getMenuItemFromTopMenuByTitle(String title) {
		return topMenuItemMap.get(title);
	}

	private JButton getButtonFromeControlMenuByTitle(String title) {
		return controlMenuButtonMap.get(title);
	}

	private JTextField getTextFieldFromeInputTableByTitle(String title) {
		return inputTableTF.get(title);
	}

	private JPanel buildMain() {
		JPanel p = new JPanel(new BorderLayout());
		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		ta.setLineWrap(true);
		p.add(sp, BorderLayout.EAST);
		p.add(buildInputTableLeft(), BorderLayout.WEST);
		p.add(buildControlMenu(), BorderLayout.SOUTH);
		return p;
	}

	private JPanel buildControlMenu() {
		JPanel p = new JPanel(new GridLayout(1, controlMenuTitle.length));
		JButton b;
		for (int i = 0; i < controlMenuTitle.length; i++) {
			b = new JButton(controlMenuTitle[i], new ImageIcon("src\\com\\day10\\ui\\img\\" + (i + 1) + ".png"));
			b.setRolloverIcon(new ImageIcon("src\\com\\day10\\ui\\img\\" + (i + 1) + ".png"));
			b.setPressedIcon(new ImageIcon("src\\com\\day10\\ui\\img\\" + (i + 1) + ".png"));
			b.setToolTipText(controlMenuTitle[i]);
			b.setMnemonic((i + 1));
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
		for (int i = 0; i < itemCnt; i++) {
			l = new JLabel(inputTableTitle[i], new ImageIcon("src\\com\\day10\\ui\\img\\수정됨_" + (i + 1) + ".png"),
					SwingConstants.LEFT);
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
		for (int i = 0; i < menuCnt; i++) {
			jb.add(buildMenu(topMenuTitle[i], i));
		}
		return jb;
	}

	private JMenu buildMenu(String menuTitle, int index) {
		String[] itemTitles = topMenuItemTitle[index];
		int menuItemCnt = itemTitles.length;
		JMenu jm = new JMenu(menuTitle);
		JMenuItem ji;
		for (int i = 0; i < menuItemCnt; i++) {
			if (itemTitles[i].equals("sep")) {
				jm.add(new JSeparator());
			} else {
				ji = new JMenuItem(itemTitles[i]);
				topMenuItemMap.put(menuTitle, ji);
				jm.add(ji);
			}
		}

		return jm;
	}

	private boolean checkJumin(String s) {
		return Pattern.matches("\\d{6}\\-[1-4]\\d{6}", s);
	}

	private String getZenderFromJumin(String id) {
		char zen = id.charAt(7);
		String result;

		if (zen == '1' || zen == '3' || zen == '9')
			result = "남자";
		else // if(zen == '2' ||zen == '0'||zen == '4')
			result = "여자";

		return result;
	}

	private String getAgeFromJumin(String id) {
		char zen = id.charAt(7);
		String str_b = id.substring(0, 2);
		int int_b = Integer.parseInt(str_b);
		int base = 1900;
		int age_koStyle;
		int age_fullYear;

		if (zen == '3' || zen == '4') 
			base = 2000;
		else if (zen == '0' || zen == '9')
			base = 1800;

		Calendar today = Calendar.getInstance();
		Calendar birthDay = Calendar.getInstance();
		birthDay.set((base + int_b), (Integer.parseInt(id.substring(2, 4)) - 1), Integer.parseInt(id.substring(4, 6)));

		age_koStyle = today.get(Calendar.YEAR) - (base + int_b) + 1;
		age_fullYear = age_koStyle - 1;

		if (birthDay.get(Calendar.MONTH) > today.get(Calendar.MONTH)) {
			age_fullYear--;
		} else if (birthDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)
				&& birthDay.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)) {
			age_fullYear--;
		}
		return String.valueOf(age_fullYear);
	}

	private String getDistrictFromJumin(String id) {
		String result;
		char dis = id.charAt(8);
		switch (dis) {
		case '0':
			result = "서울";
			break;
		case '1':
			result = "인천/부산";
			break;
		case '2':
			result = "경기";
			break;
		case '7':
			result = "경상도";
			break;
		case '9':
			result = "제주";
			break;
		default:
			result = "한국인";
		}
		return result;
	}

	public void addLayout() {
		mainPanel = buildMain();

		add(mainPanel);
		setJMenuBar(buildMenuBar());
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addEvent() {
		// 컨트롤 패널 버튼 리스너////////////////////////////////////
		getButtonFromeControlMenuByTitle("입력").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "입력");
			}
		});
		getButtonFromeControlMenuByIndex(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "수정");
			}
		});
		getButtonFromeControlMenuByIndex(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "삭제");
			}
		});
		getButtonFromeControlMenuByIndex(3).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "전체보기");
			}
		});
		getButtonFromeControlMenuByIndex(4).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "종료");
			}
		});

		// 입력창 텍스트 입력 리스너
		getTextFieldFromeInputTableByIndex(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField) e.getSource();
				String t = tf.getText();
				if(checkJumin(t)) {
					getTextFieldFromeInputTableByTitle("성별").setText(getZenderFromJumin(t));
					getTextFieldFromeInputTableByTitle("나이").setText(getAgeFromJumin(t));
					getTextFieldFromeInputTableByTitle("출신지").setText(getDistrictFromJumin(t));
				}
			}
		});
	}
}
