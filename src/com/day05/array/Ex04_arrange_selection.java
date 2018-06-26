package com.day05.array;

public class Ex04_arrange_selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] lotto = new int[6];
		int cnt=0;
		int num=0;
		StringBuffer sb = new StringBuffer();
		
		//중복된 수 없이 로또 생성.
		cnt = lotto.length;
		int i=0;
		TOP:
		while(i<cnt) {
			num = (int)((Math.random()*45)+1);
			
			for(int j=0;j<i;j++) {
				if(lotto[j]==num) {					
					continue TOP;				
				}
			}			
			lotto[i] = num;
			
			sb.append(num).append(' ');
			i++;
		}
		System.out.println(sb);
		sb.setLength(0);
		//정렬
		i=0;//첫 인덱스를 기준수로 지정		
		while(i<cnt-1) {//마지막인덱스-1까지 반복
			for(int j=i+1;j<cnt;j++) {//기준수+1인덱스~마지막인덱스까지 반복
				if(lotto[i]>lotto[j]) {//기준수가 크다면 교환
					num = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = num;
				}
			}
			i++;
		}
		
		i=0;
		while(i<cnt) {
			sb.append(lotto[i]).append(' ');
			i++;
		}
		System.out.println(sb);
	}
}
