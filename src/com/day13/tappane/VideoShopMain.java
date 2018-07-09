package com.day13.tappane;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class VideoShopMain extends JFrame{
	
	APane ap;
	BPane bp;
	CPane cp;
	
	public VideoShopMain() {
		ap = new APane();
		bp = new BPane();
		cp = new CPane();
		
		JTabbedPane pane = new JTabbedPane();
		pane.add("고객관리", ap);
		pane.add("비디오관리", bp);
		pane.add("대여관리", cp);
		
		add(pane, BorderLayout.CENTER);
		
		setSize(400, 300);
		setLocation(100,100);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VideoShopMain();
	}

}
