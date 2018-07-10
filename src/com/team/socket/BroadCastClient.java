package com.team.socket;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BroadCastClient implements Runnable,ActionListener {
	int tcpPORT = 5000;
	int udpPORT = 3001;
	JFrame f;
	
	JFileChooser fc;
	JTextField fileUrlTF;
	JButton sendMp3B;
	
	JTextField connTF, sendTF;
	JButton connB, sendB;
	JTextArea ta;
	
	Socket s;
	BufferedReader in;
	OutputStream out;

	// 추가0 : 대화명을 바꾸기
	JTextField changeNameTF;
	JButton    changeNameB;

	// 추가2 : 방인원의 대명 보여주기
	// 변수 선언
	JList  memberList;
	Vector list;
	
	public BroadCastClient() {
		f = new JFrame("Chat Client");
		
		fc = new JFileChooser("d:\\");
		fc.showOpenDialog(null);
		fileUrlTF = new JTextField(fc.getSelectedFile().getAbsolutePath());
		sendMp3B = new JButton("전송시작");
		
		connTF = new JTextField();
		sendTF = new JTextField();
		connB = new JButton("접 속");
		sendB = new JButton("확 인");
		ta = new JTextArea(15,40);
		
		JPanel p_sendMp3 = new JPanel();
//		p_sendMp3.add(fc);
		p_sendMp3.add(fileUrlTF);
		p_sendMp3.add(sendMp3B);
		// 추가0: 대화명 바꾸기
		changeNameTF	= new JTextField("guest", 10);
		changeNameB		= new JButton("바꾸기");
		JPanel p_changeName = new JPanel();
		p_changeName.add( new JLabel("대화명 : "),"West" );
		p_changeName.add(changeNameTF, "Center");
		p_changeName.add(changeNameB, "East");
		
		JPanel p_serverName = new JPanel();
		p_serverName.setLayout( new BorderLayout() );
		p_serverName.add( new JLabel("서버입력 : "),"West" );
		p_serverName.add(connTF, "Center");
		p_serverName.add(connB, "East");

		JPanel p_north = new JPanel();
		p_north.setLayout( new GridLayout(1, 2));
		p_north.add( p_sendMp3 );
		p_north.add( p_changeName );
		p_north.add( p_serverName );

		JPanel p2 = new JPanel();
		p2.setLayout( new BorderLayout() );
		p2.add( new JLabel("메세지입력 : "),"West" );
		p2.add(sendTF,"Center");
		p2.add(sendB, "East");
		
		// 추가2 : 방인원의 대명 보여주기
		memberList = new JList();
		list		= new Vector();
		JPanel  p_east = new JPanel();
		p_east.setLayout( new BorderLayout());
		p_east.add("North", new JLabel("   우 리 방 멤 버   "));
		p_east.add("Center", memberList );
		


		f.getContentPane().add("North", p_north);
		f.getContentPane().add("Center", new JScrollPane(ta));
		f.getContentPane().add("South", p2);
		f.getContentPane().add("East", p_east);
		
		//f.setSize(500, 300);
		f.pack();
		f.setVisible(true);
		

		// 클라이언트 종료시
		// 1. "종료"한다는 메세지를 서버에 보내기
		// 2. 소켓및 스트림 닫기
		// 3. 화면( 프레임) 안 보이기 하고
		// 4. 자원 반납
		// 5. 프로그램 나가기
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		f.addWindowListener( new WindowAdapter(){
			public void windowClosing( WindowEvent ev){
				if( s.isConnected()){
					try{
					out.write(("/exit BYE\n").getBytes());

					in.close();
					out.close();
					} catch(Exception ex){
						System.out.println("종료시 에러:"+ex.getMessage());
					}
				}
				f.setVisible(false);
				f.dispose();
				System.exit(0);
			}
		}
		);

		connTF.addActionListener(this);
		connB.addActionListener(this);
		sendTF.addActionListener(this);
		sendB.addActionListener(this);

		//  추가0: 대화명 바꾸기
		changeNameTF.addActionListener(this);
		changeNameB.addActionListener(this);
	}// 생성자 종료
	
	public void actionPerformed( ActionEvent e ) {
		Object o = e.getSource();

		if( o == connTF || o == connB ) {
			connProc();
		}
		
		else if( o == sendTF || o == sendB ) {
			sendProc();
		}

		//  추가0: 대화명 바꾸기
		else if( o == changeNameTF || o == changeNameB ) {
			changeNameProc();
		}
		
		else if( o == sendMp3B) {
			sendMp3();
		}
	} // actionPerformed ends
	

	private void sendMp3() {
		
	}

	void changeNameProc(){
		try{
			out.write(("/name "+changeNameTF.getText() + "\n").getBytes());
		} catch( Exception ex ) {
			ta.append(ex + "\n" );
		}
	}

	void connProc() {
		try{
			s.close();
			s = null;
		}catch( Exception ex ) { }
		
		try{
			s = new Socket(connTF.getText(), tcpPORT );
			in = new BufferedReader( new InputStreamReader ( s.getInputStream()));
			out = s.getOutputStream();
			
			new Thread(this).start();

			// 추가1: 방에 첨 들어왔을때
			enterRoom(); 
		} catch(Exception ex) {
			ta.append( ex.toString() );
		}
	} // connProc ends
	

	void enterRoom(){
		try{
			out.write(("/start "+changeNameTF.getText() + "\n").getBytes());
		} catch( Exception ex ) {
			ta.append(ex + "\n" );
		}
	}

	void sendProc() {
		try{
			out.write((sendTF.getText() + "\n").getBytes());
			//sendTF.requestFocus();
			sendTF.setText("");
		} catch( Exception ex ) {
			ta.append(ex + "\n" );
		}
	}// sendProc ends
	
	@Override
	public void run() {
		while(s.isConnected()) {
			try{
				String msg = in.readLine();
				if( msg == null ) return;

				// 추가2: 새로운 멤버 리스트에 출력
				StringTokenizer st = new StringTokenizer(msg);
				if( st.countTokens() > 1 ) {
					String temp = st.nextToken();
					
					if( temp.equalsIgnoreCase("/member" )) {
						// 기존 벡터값 지우고 다시 서버에서 넘겨받아 벡터에 추가
						list.removeAllElements();
						while( st.hasMoreTokens() ){
							list.addElement( st.nextToken() );
							memberList.setListData( list );
						}
						continue;
					}
				}

				// 화면에 넘겨받은 메세지 출력
				ta.append( msg + "\n");
				
				// ta.setSelectionStart(ta.getText().length());  스크롤바 내리기
			} catch( Exception ex ){ return; }
		}
	}// run ends
	
	public static void main(String [] args ) {
		new BroadCastClient();
	}

}
