package view;

import java.awt.*;
import javax.swing.*;

import model.CustomerModel;
import model.vo.Customer;

import java.awt.event.*;
import java.util.ArrayList;

public class CustomerView extends JPanel {
	JTextField tfCustName, tfCustTel, tfCustTelAid, tfCustAddr, tfCustEmail;
	JButton bCustRegist, bCustModify;

	JTextField tfCustNameSearch, tfCustTelSearch;
	JButton bCustNameSearch, bCustTelSearch;

	CustomerModel db;
	ArrayList<Customer> mSearchedList;
	
	public CustomerView() {
		addLayout();
		connectDB();
		eventProc();
	}

	public void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();

		// 이벤트 등록
		bCustRegist.addActionListener(btnHandler);
		bCustModify.addActionListener(btnHandler);
		bCustNameSearch.addActionListener(btnHandler);
		bCustTelSearch.addActionListener(btnHandler);
	}

	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			Object o = ev.getSource();

			if (o == bCustRegist) {
				registCustomer(); // 회원등록
			} else if (o == bCustModify) {
				updateCustomer(); // 회원정보수정
			} else if (o == bCustTelSearch) { // 이름검색
				searchByTel(); // 전화번호 검색
			} else if (o == bCustNameSearch) { // 이름검색
				searchByName();
			}
		}
	}

	private void showCusInfo(Customer dao) {
		tfCustTel.setText(dao.getCustTel1());
		tfCustTelAid.setText(dao.getCustTel2());
		tfCustName.setText(dao.getCustName());
		tfCustAddr.setText(dao.getCustAddr());
		tfCustEmail.setText(dao.getCustEmail());
	}

	private void resetCusInfo() {
		tfCustTel.setText(null);
		tfCustTelAid.setText(null);
		tfCustName.setText(null);
		tfCustAddr.setText(null);
		tfCustEmail.setText(null);
	}
	
	private void showDialForSelectingOneFromCusList(ArrayList<Customer> list) {
		Object[] olist = list.toArray();
		Object[] possibilities = {"ham", "spam", "yam"};
		String s = (String)JOptionPane.showInputDialog(
		                    this,
		                    "회원을 선택해주세요.",
		                    "회원 선택",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "ham");
		
	}

	// 회원가입하는 메소드
	public void registCustomer() {

		// 1. 화면 텍스트필드의 입력값 얻어오기
		// 2. 1값들을 Customer 클래스의 멤버로지정
		// 3. Model 클래스 안에 insertCustomer () 메소드 호출하여 2번 VO 객체를 넘김
		// 4. 화면 초기화
		int result = 0;
		Customer dao = new Customer();
		dao.setCustTel1(tfCustTel.getText());
		dao.setCustTel2(tfCustTelAid.getText());
		dao.setCustName(tfCustName.getText());
		dao.setCustAddr(tfCustAddr.getText());
		dao.setCustEmail(tfCustEmail.getText());

		try {
			result = db.insertCustomer(dao);
			resetCusInfo();
			JOptionPane.showMessageDialog(null, result+"건의 회원정보가 입력되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원입력 실패:" + e.getMessage());
		}
	}

	// 전화번호에 의한 검색
	public void searchByTel() {
		// 1. 입력한 전화번호 얻어오기
		// 2. Model의 전화번호 검색메소드 selectByTel() 호출
		// 3. 2번의 넘겨받은 Customer의 각각의 값을 화면 텍스트 필드 지정
		try {
			Customer dao = db.selectByTel(tfCustTelSearch.getText());
			showCusInfo(dao);
			JOptionPane.showMessageDialog(null, "검색");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원입력 실패:" + e.getMessage());
		}
	}

	// 이름에 의한 검색
	public void searchByName() {
		// 1. 입력한 이름 얻어오기
		// 2. Model의 전화번호 검색메소드 selectByName() 호출
		// 3. 2번의 넘겨받은 Customer의 각각의 값을 화면 텍스트 필드 지정
		String name = tfCustNameSearch.getText();
		try {
			mSearchedList = db.selectByName(name);
			JOptionPane.showMessageDialog(null, mSearchedList.size()+"건의 회원정보가 검색되었습니다.");
			if(mSearchedList.size()>1) {
				showDialForSelectingOneFromCusList(mSearchedList);
			}else if(mSearchedList.size() == 1) {
				showCusInfo(mSearchedList.get(0));
			}else {
				JOptionPane.showMessageDialog(null, "["+name+"]"+ "은 회원목록에 없는 이름입니다.");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원입력 실패:" + e.getMessage());
		}
	}

	

	// 회원정보수정
	public void updateCustomer() {
		int result = 0;
		Customer dao = new Customer();
		dao.setCustTel1(tfCustTel.getText());
		dao.setCustTel2(tfCustTelAid.getText());
		dao.setCustName(tfCustName.getText());
		dao.setCustAddr(tfCustAddr.getText());
		dao.setCustEmail(tfCustEmail.getText());

		try {
			result = db.updateCustomer(dao);
			JOptionPane.showMessageDialog(null, result + " 건의 회원정보가 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원수정 실패:" + e.getMessage());
		}

	}

	public void connectDB() {
		try {
			db = new CustomerModel();
			System.out.println("고객 디비 연결");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("고객 디비 연결 실패:" + e.getMessage());
		}
	}

	public void addLayout() {

		tfCustName = new JTextField(20);
		tfCustTel = new JTextField(20);
		tfCustTelAid = new JTextField(20);
		tfCustAddr = new JTextField(20);
		tfCustEmail = new JTextField(20);

		tfCustNameSearch = new JTextField(20);
		tfCustTelSearch = new JTextField(20);

		bCustRegist = new JButton("회원가입");
		bCustModify = new JButton("회원수정");
		bCustNameSearch = new JButton("이름검색");
		bCustTelSearch = new JButton("번호검색");

		// 회원가입 부분 붙이기
		// ( 그 복잡하다던 GridBagLayout을 사용해서 복잡해 보임..다른 쉬운것으로...대치 가능 )
		JPanel pRegist = new JPanel();
		pRegist.setLayout(new GridBagLayout());
		GridBagConstraints cbc = new GridBagConstraints();
		cbc.weightx = 1.0;
		cbc.weighty = 1.0;
		cbc.fill = GridBagConstraints.BOTH;
		cbc.gridx = 0;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	이	름	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(tfCustName, cbc);
		cbc.gridx = 2;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(bCustModify, cbc);
		cbc.gridx = 3;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(bCustRegist, cbc);

		cbc.gridx = 0;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	전	화	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(tfCustTel, cbc);
		cbc.gridx = 2;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel(" 추가전화  "), cbc);
		cbc.gridx = 3;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(tfCustTelAid, cbc);

		cbc.gridx = 0;
		cbc.gridy = 2;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	주	소	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 2;
		cbc.gridwidth = 3;
		cbc.gridheight = 1;
		pRegist.add(tfCustAddr, cbc);

		cbc.gridx = 0;
		cbc.gridy = 3;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	이메일	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 3;
		cbc.gridwidth = 3;
		cbc.gridheight = 1;
		pRegist.add(tfCustEmail, cbc);

		// 회원검색 부분 붙이기
		JPanel pSearch = new JPanel();
		pSearch.setLayout(new GridLayout(2, 1));
		JPanel pSearchName = new JPanel();
		pSearchName.add(new JLabel("		이 	름	"));
		pSearchName.add(tfCustNameSearch);
		pSearchName.add(bCustNameSearch);
		JPanel pSearchTel = new JPanel();
		pSearchTel.add(new JLabel("	전화번호	"));
		pSearchTel.add(tfCustTelSearch);
		pSearchTel.add(bCustTelSearch);
		pSearch.add(pSearchName);
		pSearch.add(pSearchTel);

		// 전체 패널에 붙이기
		setLayout(new BorderLayout());
		add("Center", pRegist);
		add("South", pSearch);

	}

}
