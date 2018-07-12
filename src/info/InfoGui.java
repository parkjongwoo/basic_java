package info;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.util.database.SQLConnectionExcutor;
import com.util.database.SQLOracleConnector;

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
	
	private String searchedPhoneNum = null;
	private SQLConnectionExcutor sce;
	
	public InfoGui() {}

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
		ta.setPreferredSize(new Dimension(300, 250));
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
	
	private boolean insert() {	
		InfoVO vo = new InfoVO(
				getTextFieldFromeInputTableByIndex(0).getText(),
				getTextFieldFromeInputTableByIndex(1).getText(),
				getTextFieldFromeInputTableByIndex(2).getText(),
				getTextFieldFromeInputTableByIndex(3).getText(),
				Integer.parseInt(getTextFieldFromeInputTableByIndex(4).getText()),
				getTextFieldFromeInputTableByIndex(5).getText());
		
		try {
			sce.insert(vo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "입력실패"+e.getMessage());
			return false;
		}		
	}
	
	private boolean modifyInfo() {	
		InfoVO vo = new InfoVO(
				getTextFieldFromeInputTableByIndex(0).getText(),
				getTextFieldFromeInputTableByIndex(1).getText(),
				getTextFieldFromeInputTableByIndex(2).getText(),
				getTextFieldFromeInputTableByIndex(3).getText(),
				Integer.parseInt(getTextFieldFromeInputTableByIndex(4).getText()),
				getTextFieldFromeInputTableByIndex(5).getText());
		
		try {
			sce.update(vo,searchedPhoneNum);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "입력실패"+e.getMessage());
			return false;
		}
	}
	
	private void searchWithPhoneNum(String phoneNum) {
		InfoVO vo = null;
		try {
			vo = sce.searchPhoneNum(phoneNum);
			if(vo == null) {
				JOptionPane.showMessageDialog(null, "없는 학생입니다.");
			}else {
				showInfo(vo);
				searchedPhoneNum = phoneNum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "찾기실패"+e.getMessage());
		}		
	}
	
	private boolean deleteInfoByPhoneNum(String phoneNum) {
		try {
			int result = sce.deleteInfoByPhoneNum(phoneNum);
			if(result <= 0) {
				JOptionPane.showMessageDialog(null, "이미 없는 학생입니다.");
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "삭제 실패"+e.getMessage());
			return false;
		}
	}
	
	private void searchAll() {
		try {
			ArrayList<InfoVO> voList = sce.searchAll();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<voList.size();i++) {
				sb.append(voList.get(i).toString());
			}
			ta.setText(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "찾기실패"+e.getMessage());
		}
	}
	
	private void clearTextField() {
		for(int i=0;i<inputTableTitle.length;i++) {
			getTextFieldFromeInputTableByIndex(i).setText(null);
		}
		searchedPhoneNum = null;
	}
	
	private void showInfo(InfoVO i) {
		getTextFieldFromeInputTableByIndex(0).setText(i.getName());
		getTextFieldFromeInputTableByIndex(1).setText(i.getPhoneNum());
		getTextFieldFromeInputTableByIndex(2).setText(i.getpID());
		getTextFieldFromeInputTableByIndex(3).setText(i.getZender());
		getTextFieldFromeInputTableByIndex(4).setText(String.valueOf(i.getAge()));
		getTextFieldFromeInputTableByIndex(5).setText(i.getHome());
	}
	
	
	
	public void addLayout() {
		mainPanel = buildMain();

		add(mainPanel);
		setJMenuBar(buildMenuBar());
		setSize(600, 300);
		setVisible(true);		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public void addEvent() {
		// 컨트롤 패널 버튼 리스너////////////////////////////////////
		getButtonFromeControlMenuByTitle("입력").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(insert()) {
					clearTextField();
					searchAll();					
				}
			}			
		});
		getButtonFromeControlMenuByTitle("수정").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modifyInfo()) {
					clearTextField();
					searchAll();
				}
			}
		});
		getButtonFromeControlMenuByTitle("삭제").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deleteInfoByPhoneNum(getTextFieldFromeInputTableByTitle("전화번호").getText())) {
					searchAll();
				}
			}			
		});
		getButtonFromeControlMenuByTitle("전체보기").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchAll();
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
		getTextFieldFromeInputTableByTitle("전화번호").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField) e.getSource();				
				searchWithPhoneNum(tf.getText());
			}				
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				if(JOptionPane.showConfirmDialog(null, "정말 나가나?","종료",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
					dispose();
				}
			}
		});
		getTextFieldFromeInputTableByTitle("전화번호").addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "전화번호는 10자 이상 입력하세요.");
			}
		});
		getButtonFromeControlMenuByTitle("종료").addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(JOptionPane.showConfirmDialog(null, "정말 나가나?","종료",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
					dispose();
				}
			}			
		});
	}

	public void connectToDB() {
		// TODO Auto-generated method stub
		try {
			sce = new SQLConnectionExcutor(new SQLOracleConnector("scott", "tiger", "jdbc:oracle:thin:@localhost:1521:orcl"));
		
			System.out.println("접속 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}
}
