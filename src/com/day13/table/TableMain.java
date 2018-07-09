package com.day13.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

public class TableMain {
	
	JFrame f;
	JTable table;
	JButton btn;
	MyTableModel model;
	
	class MyTableModel extends AbstractTableModel{
		String[] colNames = {"하나","둘","셋","넷"};
		ArrayList data = new ArrayList<>();
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return colNames.length;
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList)data.get(rowIndex);
			return temp.get(columnIndex);
		}
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return colNames[column];
		}
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return columnIndex>=2;
		}
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList)data.get(rowIndex);
			temp.set(columnIndex, aValue);
			fireTableCellUpdated(rowIndex, columnIndex);
		}	
	}
	
	public TableMain() {
		f = new JFrame("테이블 예제");
		btn = new JButton("눌러주세요");
		model = new MyTableModel();
		table = new JTable(model);
		
		f.setLayout(new BorderLayout());
		f.add(new JScrollPane(table), BorderLayout.CENTER);
		f.add(btn, BorderLayout.SOUTH);
		
		f.setSize(300, 600);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				change();				
			}
		});
	}
	
	private void change() {
		ArrayList data = new ArrayList<>();
		for(int i=0;i<5;i++) {
			ArrayList temp = new ArrayList<>();
			for(int j=0;j<4;j++) {
				temp.add(i+"와"+j);
			}
			data.add(temp);
		}
		
		model.data = data;
		table.setModel(model);
		model.fireTableDataChanged();
	}
	
	public static void main(String[] args) {
		new TableMain();
	}

}
