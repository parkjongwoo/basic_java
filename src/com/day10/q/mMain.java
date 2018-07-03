package com.day10.q;

public class mMain {
	
	static Mobile[] ms;
	
	public static void main(String[] args) {
		ms = new Mobile[]{
				new Ltab("Ltab",500,"ABC-01"),
				new Otab("Otab",1000,"XYZ-20")};
		
		printMobile();
		
		System.out.println("10분 충전");
		ms[0].charge(10);
		ms[1].charge(10);
		printMobile();
		
		System.out.println("15분 통화");
		ms[0].operate(5);
		ms[1].operate(5);
		printMobile();
	}
	
	static void printMobile() {
		StringBuffer sb = new StringBuffer();
		sb.append("Mobile").append("\t\t").append("Battery").append("\t\t").append("OS").append('\n').
		append("-----------------------------------------").append('\n');
		
		for(int i=0;i<ms.length;i++) {
			sb.append(ms[i].getMobileName()).append("\t\t").append(ms[i].getBatterySize()).append("\t\t").append(ms[i].getOsType()).append('\n');
		}
		System.out.println(sb);
	}
}
