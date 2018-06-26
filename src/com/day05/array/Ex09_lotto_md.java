package com.day05.array;

public class Ex09_lotto_md {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] lotto = new int[5][6];
		int cnt=0;
		int num=0;
		StringBuffer sb = new StringBuffer();
		
		//로또 배열만큼 생성 6개 숫자를 5묶음
		for(int k=0;k<lotto.length;k++) {
			cnt = lotto[k].length;//n경기째의 로또 숫자 갯수 산정
			TOP:
			for(int i=0;i<cnt;i++) {//n경기째의 로또 숫자 갯수만큼 반복
				num = (int)((Math.random()*45)+1);//랜덤 숫자
				
				for(int j=0;j<i;j++) {//i-1번째까지 반복
					if(lotto[k][j]==num) {//중복이 있으면
						i--;//이번순번 다시 반복
						continue TOP;//비교 초기화		
					}
				}			
				lotto[k][i] = num;				//중복 없으므로 저장
				sb.append(num).append('\t');	
			}
			sb.append('\n');
		}
		System.out.println(sb);//결과 출력
		System.out.println();
		sb.setLength(0);
		
		//정렬	
		
		for(int k=0;k<lotto.length;k++) {//로또 게임수 반복 
			cnt = lotto[k].length;//n번째 로또게임의 숫자 갯수 산정
			for(int i=0;i<cnt-1;i++) {//마지막인덱스-1까지 반복
				for(int j=i+1;j<cnt;j++) {//기준수+1인덱스~마지막인덱스까지 반복
					if(lotto[k][i]>lotto[k][j]) {//기준수가 크다면 교환
						num = lotto[k][i];
						lotto[k][i] = lotto[k][j];
						lotto[k][j] = num;
					}
				}
			}			
		}
		
		for(int k=0;k<lotto.length;k++) {
			cnt = lotto[k].length;
			for(int i=0;i<cnt;i++) {
				sb.append(lotto[k][i]).append('\t');				
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
