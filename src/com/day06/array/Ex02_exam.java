package com.day06.array;

public class Ex02_exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//합이 가장 큰 행
//		1. 각행별로 합 구하기
//		2. 배열변수에 가장 큰 값 찾기
//		3. 2의 값이 몇 번째 행인지
		int a[][]=new int[][]{
			{3,-5, 12 }, 
			{-2, 11, 2, -7}, 
			{21, -21, -35, -93, -11}, 
			{9, 14, 39,-98}};
		
		int[] sum = new int[a.length];
		int[] max = new int[a.length];
		int[] line = new int[a.length];
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				sum[i] += a[i][j];
				
				if(max[i]<a[i][j]) {
					max[i] = a[i][j];
					line[i] = j;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			sb.append(i+1).append("행의 합은 ").append(sum[i]).append("입니다.\n");
			sb.append(i+1).append("행의 가장 큰 값은 ").append(max[i]).append("입니다.\n");
			sb.append(i+1).append("행의 가장 큰 값의 위치는 ").append(line[i]+1).append("번째 입니다.\n");
		}
		
		System.out.println(sb);
	}

}
