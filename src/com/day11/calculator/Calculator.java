package com.day11.calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private String[] controlMenuTitle = { "1","2","3","4","5","6","7","8","9","+","0","=","-","*","/" };
	private Map<String, JButton> controlMenuButtonMap = new HashMap<String, JButton>();
	private JTextField inputWindow;
	private JPanel mainPanel;
	
	private JButton getButtonFromeControlMenuByIndex(int itemIndex) {
		return getButtonFromeControlMenuByTitle(controlMenuTitle[itemIndex]);
	}
	
	private JButton getButtonFromeControlMenuByTitle(String title) {
		return controlMenuButtonMap.get(title);
	}
	
	private JPanel buildMain() {
		JPanel p = new JPanel(new BorderLayout());
		inputWindow = new JTextField();
		inputWindow.setPreferredSize(new Dimension(300, 200));
		
		p.add(inputWindow, BorderLayout.NORTH);
		p.add(buildControlMenu(), BorderLayout.SOUTH);
		return p;
	}
	
	private JPanel buildControlMenu() {
		JPanel p = new JPanel(new GridLayout(5,3));
		p.setPreferredSize(new Dimension(300, 400));
		JButton b;
		for (int i = 0; i < controlMenuTitle.length; i++) {
			b = new JButton(controlMenuTitle[i]);
			b.setMnemonic((i + 1));
			controlMenuButtonMap.put(controlMenuTitle[i], b);
			p.add(b);
		}
		return p;
	}
	
	public void addLayout() {
		mainPanel = buildMain();

		add(mainPanel);
//		setJMenuBar(buildMenuBar());
		setSize(300, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addEvent() {
		for(int i=0;i<controlMenuTitle.length;i++) {
			getButtonFromeControlMenuByIndex(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton jb = (JButton)e.getSource();
					String oldStr = inputWindow.getText();
					String newStr = oldStr + jb.getText();
					inputWindow.setText(newStr);
				}
			});			
		}
	}
}
