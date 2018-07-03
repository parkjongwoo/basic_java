package com.day10.q;

public abstract class Mobile {
	
	protected String mMobileName;
	protected int mBatterySize;
	protected String mOsType;
	
	public Mobile() {}

	public Mobile(String mobileName, int batterySize, String osType) {
		super();
		this.mMobileName = mobileName;
		this.mBatterySize = batterySize;
		this.mOsType = osType;
	}
	
	public String getMobileName() {
		return mMobileName;
	}

	public void setMobileName(String mMobileName) {
		this.mMobileName = mMobileName;
	}

	public int getBatterySize() {
		return mBatterySize;
	}

	public void setBatterySize(int mBatterySize) {
		this.mBatterySize = mBatterySize;
	}

	public String getOsType() {
		return mOsType;
	}

	public void setmOsType(String mOsType) {
		this.mOsType = mOsType;
	}

	public abstract void operate(int time);
	public abstract void charge(int time);
}
