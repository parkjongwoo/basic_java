package com.day12.date;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ComboBoxMain {
	JFrame f;
	JComboBox<Integer> cbY, cbM, cbD;
	JLabel la;
	JButton btn;
	Calendar c;
	
	public ComboBoxMain() {
		f = new JFrame("오늘의 날짜");
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		c = Calendar.getInstance();
		
	}
	
	public void addLayout() {	
		cbY = new JComboBox<Integer>();
		cbM = new JComboBox<Integer>();		
		cbD = new JComboBox<Integer>();
		btn = new JButton("재생");
		la = new JLabel("라벨");
		
		updateYear();
		updateMonth();
		updateDate();
		
		JPanel panel = new JPanel();
		panel.add(cbY);panel.add(new JLabel("년"));
		panel.add(cbM);panel.add(new JLabel("월"));
		panel.add(cbD);panel.add(new JLabel("일"));
		panel.add(btn);
		panel.add(la);
		
		cbY.addActionListener(new ComboboxActionListener());
		cbM.addActionListener(new ComboboxActionListener());
		cbD.addActionListener(new ComboboxActionListener());
		btn.addActionListener(new ButtonActionListener());
		f.add(panel);
		f.setSize(400, 150);
		f.setVisible(true);
	}
	
	public void addEvent() {
		
	}
	public void updateYear() {	
		Integer[] strY = new Integer[11];
		Calendar c = Calendar.getInstance();
		int firstY = c.get(Calendar.YEAR)-5;
		for(int i=firstY;i<=firstY+10;i++) {
			strY[i-firstY] = i;			
		}
		cbY.setModel(new DefaultComboBoxModel<Integer>(strY));
	}
	private void updateMonth() {
		Integer[] strM = new Integer[12];
		for(int i=0;i<12;i++) {
			strM[i] = i+1;
			cbM.addItem(strM[i]);
		}
		cbM.setModel(new DefaultComboBoxModel<Integer>(strM));
	}
	private void updateDate() {
		int lastDayOfThisMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		Integer[] strD = new Integer[lastDayOfThisMonth];		
		for(int i=0;i<lastDayOfThisMonth;i++) {
			strD[i] = i+1;
		}	
		cbD.setModel(new DefaultComboBoxModel<Integer>(strD));
		updateDay();
	}
	
	private void updateDay() {
		la.setText(c.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT_FORMAT,Locale.KOREA));
	}
	
	class ComboboxActionListener implements ActionListener{

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox<Integer> cb = (JComboBox<Integer>)e.getSource();
			if(cb == cbY) {
				c.set(Calendar.YEAR, (Integer)cbY.getSelectedItem());				
				updateDate();
			}else if(cb == cbM) {
				c.set(Calendar.MONTH, (Integer)cbM.getSelectedItem()-1);
				updateDate();
			}else if(cb == cbD) {
				c.set(Calendar.DAY_OF_MONTH, (Integer)cbD.getSelectedItem());
				updateDay();
			}			
		}		
	}
	
	class ButtonActionListener implements ActionListener{

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton cb = (JButton)e.getSource();
			if(cb == btn) {
				
			}			
		}		
	}
	
	public static void main(String[] args) {
		ComboBoxMain cbMain = new ComboBoxMain();
		cbMain.addLayout();
		cbMain.addEvent();
	}

}
