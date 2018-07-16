package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.RentModel;
import model.VideoModel;
import model.vo.RentVO;

public class RentView extends JPanel {
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;

	JTextField tfReturnVideoNum;
	JButton bReturn;

	JTable tableRecentList;

	RentTableModel rentTM;

	RentModel db;

	// ==============================================
	// 생성자 함수
	public RentView() {
		addLayout(); // 화면구성
		eventProc(); // DB연결
		connectDB();
	}

	// DB 연결
	void connectDB() {
		try {
			db = new RentModel();
			System.out.println("비디오디비 연결");
		} catch (Exception e) {
			System.out.println("비디오디비 연결 실패");
			e.printStackTrace();
		}
	}

	/* 화면 구성 */
	void addLayout() {
		// 멤버변수 객체 생성
		tfRentTel = new JTextField(20);
		tfRentCustName = new JTextField(20);
		tfRentVideoNum = new JTextField(20);
		tfReturnVideoNum = new JTextField(10);

		bRent = new JButton("대여");
		bReturn = new JButton("반납");

		tableRecentList = new JTable();

		rentTM = new RentTableModel();
		tableRecentList = new JTable(rentTM);

		// ************* 화면구성 *****************
		// 화면의 윗쪽
		JPanel p_north = new JPanel();
		p_north.setLayout(new GridLayout(1, 2));
		// 화면 윗쪽의 왼쪽
		JPanel p_north_1 = new JPanel();
		p_north_1.setBorder(new TitledBorder("대		여"));
		p_north_1.setLayout(new GridLayout(4, 2));
		p_north_1.add(new JLabel("전 화 번 호"));
		p_north_1.add(tfRentTel);
		p_north_1.add(new JLabel("고 객 명"));
		p_north_1.add(tfRentCustName);
		p_north_1.add(new JLabel("비디오 번호"));
		p_north_1.add(tfRentVideoNum);
		p_north_1.add(bRent);

		// 화면 윗쪽의 오른쪽
		JPanel p_north_2 = new JPanel();
		p_north_2.setBorder(new TitledBorder("반		납"));
		p_north_2.add(new JLabel("비디오 번호"));
		p_north_2.add(tfReturnVideoNum);
		p_north_2.add(bReturn);

		//
		setLayout(new BorderLayout());
		add(p_north, BorderLayout.NORTH);
		add(new JScrollPane(tableRecentList), BorderLayout.CENTER);

		p_north.add(p_north_1);
		p_north.add(p_north_2);
	}

	class RentTableModel extends AbstractTableModel {

		ArrayList<RentVO> data = new ArrayList<RentVO>();
		String[] columnNames = { "비디오번호", "제목", "고객명", "전화번호", "반납예정일", "반납여부" };

		// =============================================================
		// 1. 기본적인 TabelModel 만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			RentVO temp = data.get(row);
			Object result = null;

			switch (col) {
			case 0:
				result = temp.getVid();
				break;
			case 1:
				result = temp.getVname();
				break;
			case 2:
				result = temp.getCname();
				break;
			case 3:
				result = temp.getCpid();
				break;
			case 4:
				result = temp.getReturnSche();
				break;
			case 5:
				result = temp.getIsReturned();
				break;
			}

			return result;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	// 이벤트 등록
	public void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();

		tfRentTel.addActionListener(btnHandler);
		bRent.addActionListener(btnHandler);
		bReturn.addActionListener(btnHandler);

		tableRecentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {

				try {
					int row = tableRecentList.getSelectedRow();
					int col = 0; // 검색한 열을 클릭했을 때 클릭한 열의 비디오번호

					Integer vNum = (Integer) (tableRecentList.getValueAt(row, col));
					// 그 열의 비디오번호를 tfReturnVideoNum 에 띄우기
					tfReturnVideoNum.setText(vNum.toString());

				} catch (Exception ex) {
					System.out.println("실패 : " + ex.getMessage());
				}

			}
		});

	}

	// 이벤트 핸들러
	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			Object o = ev.getSource();

			if (o == tfRentTel) { // 전화번호 엔터
				rentSelectTel();
			} else if (o == bRent) { // 대여 클릭
				rentClick();
			} else if (o == bReturn) { // 반납 클릭
				returnClick();
			} else if (o == tfRentCustName) { // 이름 엔터
				searchNoreturnedByCname();
			} 

		}
	}
	
	private void searchNoreturnedByCname() {
		// TODO Auto-generated method stub
		
	}
	
	// 반납버튼 눌렀을 때
	public void returnClick() {
		String vNum = tfReturnVideoNum.getText();
		try {
			db.returnVideo(vNum);
			rentSelectTel();
			System.out.println("반납성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 대여 버튼 눌렀을 때
	public void rentClick() {
		String pNum = tfRentTel.getText();
		String vNum = tfRentVideoNum.getText();
		try {
			db.rentVideo(pNum, vNum);
			System.out.println("대여성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전화번호입력후 엔터
	public void rentSelectTel() {
		
		String pNum = tfRentTel.getText();
		ArrayList<RentVO> list = null;
		try {
			list = db.searchRentedVideoByPNum(pNum);
			rentTM.data = list;
			rentTM.fireTableDataChanged();
			System.out.println("검색성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
