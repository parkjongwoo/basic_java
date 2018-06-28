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
	 * 총 배달할 봉지수 산정. 봉지수가 최소가 되도록 5,3kg봉지수를 계산
	 * @return 총 배달할 봉지수
	 */
	public int getQuantity() {
		if(!isExact() || sugarStock<=0) return -1;//봉지수가 안맞거나 0이하면 -1
		if(get5kgQ()*5 == sugarStock) //5kg봉지만 필요할 경우 5kg봉지만 반환
			return get5kgQ();
		if(get3kgQ()*3 == sugarStock) //3kg봉지만 필요할 경우 3kg봉지만 반환
			return get3kgQ();
		return get5kgQ()+get3kgQ();//3,5kg 같이 필요할 경우 최소수 반환
	}
	
	/**
	 * 5kg 필요 봉지수 반환. 필요없으면 0.
	 * @return 5kg 봉지수
	 */
	public int get5kgQ() {
		if(sugarStock % 8 == 0 || sugarStock % 8 % 3== 0 )//둘다필요한 경우 반환값
			return sugarStock / 8;
		if(sugarStock % 8 % 5 == 0)//둘다 필요하며 5kg이 많은 경우 반환값
			return sugarStock / 8 +  sugarStock % 8 / 5;
		if(sugarStock % 5 == 0)//5kg만 필요한 경우 반환
			return sugarStock / 5;
		return 0;//반환할 봉지수가 없음
	}
	
	/**
	 * 3kg 필요 봉지수 반환. 필요없으면 0.
	 * @return 3kg 봉지수
	 */
	public int get3kgQ() {
		if(sugarStock % 8 == 0 || sugarStock % 8 % 5== 0 )//둘다필요한 경우 반환값
			return sugarStock / 8;
		if(sugarStock % 8 % 3 == 0)//둘다 필요하며 3kg이 많은 경우 반환값
			return sugarStock / 8 +  sugarStock % 8 / 3;
		if(sugarStock % 3 == 0)//3kg만 필요한 경우 반환
			return sugarStock / 3;
		return 0;//반환할 봉지수가 없음
	}
	
	/**
	 * 봉지수가 맞는지 여부 반환.둘다 필요,한쪽만 필요한 경우
	 * @return 봉지수가 맞는경우 true, 안맞으면 false
	 */
	public boolean isExact() {		
		return sugarStock % 8 == 0 || sugarStock % 8 % 5 == 0 || sugarStock % 8 % 3 == 0 || sugarStock % 5 == 0 || sugarStock % 3 == 0;
	}
}
