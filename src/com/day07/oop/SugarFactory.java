package com.day07.oop;

public class SugarFactory {
	
	private int sugarStock;
	
	/**
	 * 배달할 설탕의 무게 반환
	 * @return sugarStock 배달할 설탕의 무게
	 */
	public int getSugarStock() {
		return sugarStock;
	}
	/**
	 * 배달할 설탕의 무게 저장
	 * @param sugarStock 배달할 설탕의 무게
	 */
	public void setSugarStock(int sugarStock) {
		this.sugarStock = sugarStock;
	}
	
	/**
	 * 총 배달할 봉지수 산정. 
	 * @return 총 배달할 봉지수
	 */
	public int getQuantity() {
		int ss = 0;
		for(int i=sugarStock/5;i>=0;i--) {//5
			ss = sugarStock - i * 5;
			if(ss % 3 == 0) 
				return i + ss / 3;
		}		
		return -1;
	}
}
