package crawling.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawling.model.CrawlingModel;

public class JobView extends JPanel implements ActionListener, Runnable {

	CrawlingModel db;

	JButton jb_start, jb_stop, jb_viewPer;

	JLabel jl_cate, jl_start, jl_end, jl_now;

	JTextField jtf_cate, jtf_start, jtf_end, jtf_now;

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
		add(jp_c, BorderLayout.NORTH);

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

		add(jp_l, BorderLayout.CENTER);

		jta_log = new JTextArea(20, 10);

		add(new JScrollPane(jta_log), BorderLayout.SOUTH);

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

		if (o == jb_start) {
			working = true;
			start();
		} else if (o == jb_stop) {
			working = false;
		} else if (o == jb_viewPer) {
			openPopup();
		}
	}

	private void openPopup() {

	}

	private void start() {
		Thread job = new Thread(this);
		job.start();
	}
	
	private String getCurrentTime() {
		return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
	}
	private void crawlingData() throws ClientProtocolException, IOException {
		System.out.println(" Start Date : " + getCurrentTime());
		
		HttpPost http = new HttpPost(getCrawlURLByCateAndPage(1, 1));
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse response = httpClient.execute(http);
		HttpEntity entity = response.getEntity();
		ContentType contentType = ContentType.getOrDefault(entity);
		Charset charset = contentType.getCharset();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
		StringBuffer sb = new StringBuffer();
		
		String line = "";
		
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		// 10. 가져온 아름다운 DOM을 보자
		// System.out.println(sb.toString());

		// 11. Jsoup으로 파싱해보자.
		Document doc = Jsoup.parse(sb.toString());
		Elements es = doc.select(".nutrition-result tbody tr");
		// System.out.println("nutrition-result''s-------first
		// Element\n"+es.toString());

		sb.setLength(0);
		Iterator<Element> ei = es.iterator();
		for (int i = 0, j = 1; ei.hasNext(); i++) {
			Element e = ei.next();

			if (i % 2 == 0) {
				sb.append('[').append(j).append("]:");
				sb.append("id:").append(e.child(0).text()).append(", 1회제공량:").append(e.child(2).text().trim())
						.append(", 열량:").append(e.child(3).text().trim()).append(", 탄수화물:")
						.append(e.child(4).text().trim()).append(", 단백질:").append(e.child(5).text().trim())
						.append(", 지방:").append(e.child(6).text().trim());
			} else {
				sb.append(", 이름:").append(e.child(0).child(0).text().trim()).append(", 당류:")
						.append(e.child(1).text().trim()).append(", 나트륨:").append(e.child(2).text().trim())
						.append(", 콜레:").append(e.child(3).text().trim()).append(", 포화지방:")
						.append(e.child(4).text().trim()).append(", 트랜스지방:").append(e.child(5).text().trim())
						.append('\n');
				j++;
			}

		}
		System.out.println(sb);

		// 참고 - Jsoup에서 제공하는 Connect 처리
		// Document doc2 =
		// Jsoup.connect("https://www.foodsafetykorea.go.kr/portal/healthyfoodlife/foodnutrient/simpleSearch.do?menu_grp=MENU_NEW03&menu_no=2805").get();
		// System.out.println(doc2.data());

		// 12. 얼마나 걸렸나 찍어보자
		System.out.println(" End Date : " + getCurrentTime());
	}

	@Override
	public void run() {
		while (working) {
			System.out.println("작업중");
			try {
				crawlingData();
			} catch (ClientProtocolException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public String getCrawlURLByCateAndPage(int category, int page) {
		return "https://www.foodsafetykorea.go.kr/portal/healthyfoodlife/"
				+ "foodnutrient/simpleSearch.do?menu_no=2805&menu_grp=" + "MENU_NEW03&code4=" + category + "&&page="
				+ page;
	}
}
