package com.day10.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGui2 extends Frame {
	Button b;
	MainGui2(){
		super("나의 두번째 창");
		b = new Button("hello!");
		add(b);
		setSize(400,300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				dispose();
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainGui2 gui = new MainGui2(); 
	}

}
