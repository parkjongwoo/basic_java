package com.day10.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGui {
	
	Frame f;
	Button b;
	TextField tf;
	TextArea ta;
	Checkbox cb1,cb2;
	Checkbox cb3,cb4;
	
	List l;
	public MainGui() {
		f = new Frame("나의 첫번째 창");
		
		b = new Button("내 버튼");
		tf = new TextField("이름입력", 30);
		ta = new TextArea("글입력");
		
		CheckboxGroup cbg1 = new CheckboxGroup();
		cb1 = new Checkbox("체크1",cbg1,true);
		cb2 = new Checkbox("체크2",cbg1,false);
		Panel p1 = new Panel(new GridLayout(2,1));
		p1.add(cb1);
		p1.add(cb2);
		CheckboxGroup cbg2 = new CheckboxGroup();
		cb3 = new Checkbox("수신동의",cbg2,true);
		cb4 = new Checkbox("수신동의안함",cbg2,false);
		
		l = new List(4);
		l.add("유치원졸");
		l.add("초졸");
		l.add("중졸");
		l.add("고졸");
		l.setSize(150, 150);
		
		f.setLayout(new BorderLayout(10,10));
		f.add(b, BorderLayout.NORTH);
		f.add(tf, BorderLayout.WEST);
		f.add(ta, BorderLayout.CENTER);
		f.add(l, BorderLayout.EAST);
		f.add(p1, BorderLayout.SOUTH);		
//		f.add(cb3);
//		f.add(cb4);
		
		f.setSize(800, 600);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				e.getWindow().dispose();
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainGui gui = new MainGui();
	}
	
	
}
