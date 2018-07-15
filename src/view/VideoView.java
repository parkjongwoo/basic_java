package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import model.VideoModel;
import model.vo.Genre;
import model.vo.Movie;
import model.vo.Video;

public class VideoView extends JPanel {
	// member field
	JTextField tfVideoNum, tfVideoTitle, tfVideoDirector, tfVideoActor;
	JComboBox<Genre> comVideoJanre;
	JTextArea taVideoContent;

	JCheckBox cbMultiInsert;
	JTextField tfInsertCount;

	JButton bVideoInsert, bVideoModify, bVideoDelete;

	JComboBox<String> comVideoSearch;
	JTextField tfVideoSearch;
	JTable tableVideo;

	VideoTableModel tbModelVideo;

	VideoModel db;

	// ##############################################
	// constructor method
	public VideoView() {
		connectDB(); // DB연결
		addLayout(); // 화면설계
		initStyle();
		eventProc();
	}

	private void initStyle() {
		tfVideoNum.setEditable(false);
		tfInsertCount.setEditable(false);
	}

	public void connectDB() { // DB연결
		try {
			db = new VideoModel();
			System.out.println("비디오디비 연결");
		} catch (Exception e) {
			System.out.println("비디오디비 연결 실패");
			e.printStackTrace();
		}
	}

	public void eventProc() {
		EventHandlr h = new EventHandlr();
		cbMultiInsert.addActionListener(h);
		bVideoInsert.addActionListener(h);
		bVideoModify.addActionListener(h);
		bVideoDelete.addActionListener(h);
		tfVideoSearch.addActionListener(h);
		tableVideo.getSelectionModel().addListSelectionListener(h);
	}

	private class EventHandlr implements ActionListener, ListSelectionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == cbMultiInsert) {// 다중입고
				tfInsertCount.setEditable(cbMultiInsert.isSelected());
			} else if (o == bVideoInsert) {// 비디오입고
				resistVideo();
			} else if (o == bVideoModify) {// 비디오수정
				updateVideo();
			} else if (o == bVideoDelete) {// 비디오삭제
				deleteVideo();
			} else if (o == tfVideoSearch) {// 비디오검색
				searchVideo();
			}
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting()) return;
			ListSelectionModel m = (ListSelectionModel)e.getSource();
			showVideoInfoFromTable(m.getMinSelectionIndex());
		}
	}

	private void showVideoInfoFromTable(int index) {
		if(index<0 || tbModelVideo.data.size()<=index) return;
		Video dao = tbModelVideo.data.get(index);
		tfVideoNum.setText(String.valueOf(dao.getVideoNo()));
		tfVideoTitle.setText(dao.getVideoName());
		tfVideoDirector.setText(dao.getDirector());
		tfVideoActor.setText(dao.getActor());
		comVideoJanre.setSelectedIndex(db.getGenreIndex(dao.getGenre()));
		taVideoContent.setText(dao.getExp());
	}

	private void searchVideo() {
		if(tfVideoSearch.getText()==null || "".equals(tfVideoSearch.getText().trim())) {
			JOptionPane.showMessageDialog(this, "검색어를 입력해 주세요.");
			return;
		}
		
		ArrayList<Video> model = null;
		try {
			switch (comVideoSearch.getSelectedIndex()) {
			case 0:
				model = db.searchVideoByTitle(tfVideoSearch.getText());
				break;
			case 1:
				model = db.searchVideoByDirector(tfVideoSearch.getText());
				break;
			}
		} catch (Exception e) {
			System.out.println("비디오 검색 실패");
			e.printStackTrace();
		}
		tbModelVideo.data = model;
		tbModelVideo.fireTableDataChanged();
		JOptionPane.showMessageDialog(this, model.size() + "개의 비디오가 검색되었습니다.");
	}
	
	private void deleteVideo() {
		try {
			int videoNo = Integer.parseInt(tfVideoNum.getText().trim());
			int result = db.deleteVideo(videoNo);
			JOptionPane.showMessageDialog(this, result+"개의 데이터가 삭제되었습니다.");
			clearInfo();
			searchVideo();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "삭제할 비디오를 선택해 주세요.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("비디오 삭제 실패");
			e.printStackTrace();
		} 
	}

	private void updateVideo() {
		int selectedIndex = tableVideo.getSelectedRow();
		ArrayList<Video> searchedList = ((VideoTableModel)tableVideo.getModel()).data;
		
		if(selectedIndex<0 || selectedIndex>=searchedList.size())
		{
			JOptionPane.showMessageDialog(this, "변경할 비디오를 선택해 주세요.");
		}
		Video selectedDao = ((VideoTableModel)tableVideo.getModel()).data.get(selectedIndex);
		Movie dao = Movie.createMovieFromVideo(selectedDao);
		
		dao.setMovieName(tfVideoTitle.getText());
		dao.setDirector(tfVideoDirector.getText());
		dao.setActor(tfVideoActor.getText());
		dao.setGenre(((Genre)comVideoJanre.getSelectedItem()).getGenid());
		dao.setExp(taVideoContent.getText());
		
		try {
			db.updateMovie(dao);
			clearInfo();
			searchVideo();
		} catch (Exception e) {
			System.out.println("영화 업데이트 실패");
			e.printStackTrace();
		}		
	}

	private void resistVideo() {
		// tfVideoTitle, tfVideoDirector, tfVideoActor
		int resistCnt = cbMultiInsert.isSelected() ? Integer.valueOf(tfInsertCount.getText()) : 1;
		Video dao = new Video();
		dao.setGenre(((Genre) comVideoJanre.getSelectedItem()).getGenid());
		dao.setVideoName(tfVideoTitle.getText());
		dao.setDirector(tfVideoDirector.getText());
		dao.setActor(tfVideoActor.getText());
		dao.setExp(taVideoContent.getText());

		try {
			db.insertVideo(dao, resistCnt);
			JOptionPane.showMessageDialog(this, resistCnt+"개의 데이터가 입력되었습니다.");
			clearInfo();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("비디오등록 실패" + e.getMessage());
		}
	}
	
	private void clearInfo() {
		tfVideoNum.setText(null);
		tfVideoTitle.setText(null);
		tfVideoDirector.setText(null);
		tfVideoActor.setText(null);
		comVideoJanre.setSelectedIndex(0);	
		taVideoContent.setText(null);
	}
	
	// 화면설계 메소드
	public void addLayout() {
		// 멤버변수의 객체 생성
		tfVideoNum = new JTextField();
		tfVideoTitle = new JTextField();
		tfVideoDirector = new JTextField();
		tfVideoActor = new JTextField();

		comVideoJanre = new JComboBox<Genre>( db.genreList.toArray(new Genre[db.genreList.size()]));
		taVideoContent = new JTextArea();
		cbMultiInsert = new JCheckBox("다중입고");
		tfInsertCount = new JTextField("1", 5);

		bVideoInsert = new JButton("입고");
		bVideoModify = new JButton("수정");
		bVideoDelete = new JButton("삭제");

		String[] cbVideoSearch = { "제목", "감독" };
		comVideoSearch = new JComboBox<String>(cbVideoSearch);
		tfVideoSearch = new JTextField(15);

		tbModelVideo = new VideoTableModel();
		tableVideo = new JTable(tbModelVideo);
		tableVideo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// tableVideo.setModel(tbModelVideo);

		// ************화면구성************
		// 왼쪽영역
		JPanel p_west = new JPanel();
		p_west.setLayout(new BorderLayout());
		// 왼쪽 가운데
		JPanel p_west_center = new JPanel();
		p_west_center.setLayout(new BorderLayout());
		// 왼쪽 가운데의 윗쪽
		JPanel p_west_center_north = new JPanel();
		p_west_center_north.setLayout(new GridLayout(5, 2));
		p_west_center_north.add(new JLabel("비디오번호"));
		p_west_center_north.add(tfVideoNum);
		p_west_center_north.add(new JLabel("장르"));
		p_west_center_north.add(comVideoJanre);
		p_west_center_north.add(new JLabel("제목"));
		p_west_center_north.add(tfVideoTitle);
		p_west_center_north.add(new JLabel("감독"));
		p_west_center_north.add(tfVideoDirector);
		p_west_center_north.add(new JLabel("배우"));
		p_west_center_north.add(tfVideoActor);

		// 왼쪽 가운데의 가운데
		JPanel p_west_center_center = new JPanel();
		p_west_center_center.setLayout(new BorderLayout());
		// BorderLayout은 영역 설정도 해야함
		p_west_center_center.add(new JLabel("설명"), BorderLayout.WEST);
		p_west_center_center.add(taVideoContent, BorderLayout.CENTER);

		// 왼쪽 화면에 붙이기
		p_west_center.add(p_west_center_north, BorderLayout.NORTH);
		p_west_center.add(p_west_center_center, BorderLayout.CENTER);
		p_west_center.setBorder(new TitledBorder("비디오 정보입력"));

		// 왼쪽 아래
		JPanel p_west_south = new JPanel();
		p_west_south.setLayout(new GridLayout(2, 1));

		JPanel p_west_south_1 = new JPanel();
		p_west_south_1.setLayout(new FlowLayout());
		p_west_south_1.add(cbMultiInsert);
		p_west_south_1.add(tfInsertCount);
		p_west_south_1.add(new JLabel("개"));
		p_west_south_1.setBorder(new TitledBorder("다중입력시 선택하시오"));
		// 입력 수정 삭제 버튼 붙이기
		JPanel p_west_south_2 = new JPanel();
		p_west_south_2.setLayout(new GridLayout(1, 3));
		p_west_south_2.add(bVideoInsert);
		p_west_south_2.add(bVideoModify);
		p_west_south_2.add(bVideoDelete);

		p_west_south.add(p_west_south_1);
		p_west_south.add(p_west_south_2);

		p_west.add(p_west_center, BorderLayout.CENTER);
		p_west.add(p_west_south, BorderLayout.SOUTH); // 왼쪽부분완성

		// 화면구성 - 오른쪽영역
		JPanel p_east = new JPanel();
		p_east.setLayout(new BorderLayout());

		JPanel p_east_north = new JPanel();
		p_east_north.add(comVideoSearch);
		p_east_north.add(tfVideoSearch);
		p_east_north.setBorder(new TitledBorder("비디오 검색"));

		p_east.add(p_east_north, BorderLayout.NORTH);
		p_east.add(new JScrollPane(tableVideo), BorderLayout.CENTER);
		// 테이블을 붙일때에는 반드시 JScrollPane() 이렇게 해야함

		// 전체 화면에 왼쪽 오른쪽 붙이기
		setLayout(new GridLayout(1, 2));

		add(p_west);
		add(p_east);

	}

	// 화면에 테이블 붙이는 메소드
	class VideoTableModel extends AbstractTableModel {

		ArrayList<Video> data = new ArrayList<Video>();
		String[] columnNames = { "비디오번호", "제목", "장르", "감독", "배우" };

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
			Object result = null;
			Video temp = (Video) data.get(row);
			switch (col) {
			case 0:
				result = temp.getVideoNo();
				break;
			case 1:
				result = temp.getVideoName();
				break;
			case 2:
				result = temp.getGenre();
				break;
			case 3:
				result = temp.getDirector();
				break;
			case 4:
				result = temp.getActor();
				break;
			}
			return result;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
}
