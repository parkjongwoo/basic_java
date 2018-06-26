package com.day05.array;

public class Ex06_arrange_insertion {

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
		while(i<cnt) {//배열 크기만큼 반복
			num = (int)((Math.random()*45)+1);//난수발생
			
			for(int j=0;j<i;j++) {//첫 인자~i-1번째 인자까지 반복
				if(lotto[j]==num) {//새로 뽑은 수가 먼저 뽑은 숫자와 같다면					
					continue TOP;//다시 뽑기
				}
			}			
			lotto[i] = num;	// 새로 뽑은 수가 기존 숫자와 중복 안 된 경우 저장	
			i++;// 다음 수 뽑기
		}
		printOut(lotto,sb);// 출력
		
		//삽입정렬
		int temp = 0;//임시 저장
		i=1;//두번째 수부터 기준으로 지정
		while(i<cnt) {//로또 마지막 숫자까지 반복
			for(int j=0;j<i;j++) {//첫번째 수~기준수-1까지 반복
				if(lotto[i]<lotto[j]) {//기준수보다 앞의 수가 크다면
					temp = lotto[i];//기준수 임시저장
					for(int k=i;k>j;k--) //기준수 위치~앞의 큰 수의 위치+1까지 반복
						lotto[k]= lotto[k-1];//앞의수를 뒤로 이동
					lotto[j]=temp;//앞의 큰 수의 위치에 기준수를 저장
					break;
				}			
			}
			i++;//기준수를 다음수로 넘김
		}
		
		printOut(lotto,sb);
	}
	
	/**
	 * 배열을 공백으로 구분하여 1열로 출력
	 * @param arr 출력할 배열
	 * @param sb 출력에 사용할 StringBuffer
	 */
	public static void printOut(int[] arr, StringBuffer sb) {
		sb.setLength(0);
		int cnt = arr.length;
		for(int i=0;i<cnt;i++) 
			sb.append(arr[i]).append(' ');
		System.out.println(sb);
	}
}
