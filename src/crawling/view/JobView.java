package crawling.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import crawling.model.CrawlingModel;

public class JobView extends JPanel implements ActionListener,Runnable{
	
	CrawlingModel db;
	
	JButton jb_start,jb_stop,jb_viewPer;
	
	JLabel jl_cate,jl_start,jl_end,jl_now;
	
	JTextField jtf_cate,jtf_start,jtf_end,jtf_now;
	
	JTextArea jta_log;
	
	boolean working = false;
	
	public JobView() {
		super();
		addLayout();
		eventProc();
	}

	private void addLayout() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		
		JPanel jp_c = new JPanel();
		jb_start = new JButton("작업시작");
		jb_stop = new JButton("작업종료");
		jb_viewPer = new JButton("현황보기");
		jp_c.add(jb_start);
		jp_c.add(jb_stop);
		jp_c.add(jb_viewPer);
		add(jp_c,BorderLayout.NORTH);
		
		JPanel jp_l = new JPanel(new GridLayout(4, 4));
		jl_cate = new JLabel("카테고리:");
		jl_start = new JLabel("시작페이지:");
		jl_end = new JLabel("종료페이지:");
		jl_now = new JLabel("현재작업중페이지:");	
		
		jtf_cate = new JTextField(10);
		jtf_start = new JTextField(10);
		jtf_end = new JTextField(10);
		jtf_now = new JTextField(10);
		
		jp_l.add(jl_cate);
		jp_l.add(jtf_cate);
		jp_l.add(jl_start);
		jp_l.add(jtf_start);
		jp_l.add(jl_end);
		jp_l.add(jtf_end);
		jp_l.add(jl_now);
		jp_l.add(jtf_now);
		
		add(jp_l,BorderLayout.CENTER);
		
		
		jta_log = new JTextArea(20, 10);
		
		add(new JScrollPane(jta_log),BorderLayout.SOUTH);
		
	}
	
	private void eventProc() {
		jb_start.addActionListener(this);
		jb_stop.addActionListener(this);
		jb_viewPer.addActionListener(this);
	}

	public void setModel(CrawlingModel db) {
		this.db = db;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==jb_start) {
			working = true;
			start();
		}else if(o==jb_stop) {
			working = false;
		}else if(o==jb_viewPer) {
			openPopup();
		}
	}

	private void openPopup() {
		
	}

	private void start() {
		Thread job = new Thread(this);
		job.start();		
	}

	@Override
	public void run() {
		while(working) {
			System.out.println("작업중");
		}
	}
}
