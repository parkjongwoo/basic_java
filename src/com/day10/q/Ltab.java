package com.day10.q;

public class Ltab extends Mobile {

	public Ltab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ltab(String string, int i, String string2) {
		super(string, i , string2);
	}

	@Override
	public void operate(int time) {
		// TODO Auto-generated method stub
		mBatterySize -= time*10;
	}

	@Override
	public void charge(int time) {
		// TODO Auto-generated method stub
		mBatterySize += time*10;
	}
	
}
