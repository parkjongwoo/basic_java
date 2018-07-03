package com.day10.q;

public class Otab extends Mobile {
	public Otab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Otab(String string, int i, String string2) {
		super(string, i , string2);
	}

	@Override
	public void operate(int time) {
		mBatterySize -= time*12;
	}

	@Override
	public void charge(int time) {
		// TODO Auto-generated method stub
		mBatterySize += time*8;
	}
}
