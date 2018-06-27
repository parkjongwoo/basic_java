package com.day05.array;

public class Ex11_arrange_quick {

	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		int[] lotto = new int[10];
		int cnt = 0;
		int num = 0;

		// 중복된 수 없이 로또 생성.
		cnt = lotto.length;
		int i = 0;
		TOP: while (i < cnt) {// 배열 크기만큼 반복
			num = (int) ((Math.random() * 45) + 1);// 난수발생

			for (int j = 0; j < i; j++) {// 첫 인자~i-1번째 인자까지 반복
				if (lotto[j] == num) {// 새로 뽑은 수가 먼저 뽑은 숫자와 같다면
					continue TOP;// 다시 뽑기
				}
			}
			lotto[i] = num; // 새로 뽑은 수가 기존 숫자와 중복 안 된 경우 저장
			i++;// 다음 수 뽑기
		}
		printOut(lotto);// 출력

		quickArrange(0, lotto.length - 1, lotto.length - 1, lotto);
		printOut(lotto);// 출력
	}

	/**
	 * 배열을 공백으로 구분하여 1열로 출력
	 * 
	 * @param arr
	 *            출력할 배열
	 * @param sb
	 *            출력에 사용할 StringBuffer
	 */
	public static void printOut(int[] arr) {
		sb.setLength(0);
		int cnt = arr.length;
		for (int i = 0; i < cnt; i++)
			sb.append(arr[i]).append(' ');
		System.out.println(sb);
	}

	/**
	 * -좌측 검색위치는 left인덱스부터 pivot인덱스까지 이동하며 pivot의 값보다 큰 값을 검색 -우측 검색위치는 right인덱스부터
	 * pivot인덱스까지 이동하며 pivot의 값보다 작은 값을 검색 -좌측 검색 > 우측 검색 순으로 검색 -좌측 검색값을 찾으면 멈추고 우측
	 * 검색 시작 이후 우측 검색값도 찾으면 좌우측 값을 교환 후 좌측부터 다시 시작 좌측 검색위치가 우측검색위치와 만나면 pivot과 값비교 후
	 * pivot값 교환삽입 pivot기준으로 분할 완료. 다음 회차는 left~pivot-1, pivot+1~right 두 범위를 분할하도록
	 * 재귀호출 left==right인 경우 정렬 종료.
	 * 
	 * @param left
	 *            이번 회차의 첫번째 배열 요소 인덱스
	 * @param right
	 *            이번 회차의 마지막 배열 요소 인덱스
	 * @param pivot
	 *            피봇 인덱스
	 * @param arr
	 *            정렬할 배열
	 */
	public static void quickArrange(int left, int right, int pivot, int[] arr) {
		if (left == right)
			return;// 좌우 검색위치가 동일한 경우 값이 1개이므로 정렬불가 바로 종료
		int onSearchIndex = left;// 처음 검색방향은 좌>우방향 검색
		int offSearchIndex = right;
		int temp;
		int searchDirection = 1;

		while (true) {
			if (onSearchIndex == offSearchIndex) {// 두 검색위치가 동일하면
				if (arr[onSearchIndex] > arr[pivot]) {// 현재 검색위치의 값이 피봇의 값보다 큰수면
					temp = arr[onSearchIndex];// 값교환
					arr[onSearchIndex] = arr[pivot];
					arr[pivot] = temp;
					pivot = onSearchIndex;// 피봇의 인덱스도 변경
				}
				printOut(arr);//이번회차 출력
				if (pivot - left > 1) // 피봇기준 왼쪽의 배열 원소가 2개이상 남은 경우
					quickArrange(left, pivot - 1, pivot - 1, arr);// 피봇 좌측 검색 시작
				if (right - pivot > 1)// 피봇기준 오른쪽의 배열 원소가 2개이상 남은 경우
					quickArrange(pivot + 1, right, right, arr);// 피봇 우측 검색 시작
				return;// 회차 종료
			}
			if (searchDirection == 1 && arr[onSearchIndex] > arr[pivot]) { // 우로 이동 검색중 피봇보다 큰 값을 찾으면
				temp = onSearchIndex;// 검색 위치를 전환
				onSearchIndex = offSearchIndex;
				offSearchIndex = temp;
				searchDirection *= -1;// 방향전환
				continue;// 우>좌 방향 검색시작
			}
			if (searchDirection == -1 && arr[onSearchIndex] < arr[pivot]) {// 좌로 이동 검색중 피봇값보다 작은값 찾으면
				temp = arr[onSearchIndex];// 양 검색 위치의 값을 교환
				arr[onSearchIndex] = arr[offSearchIndex];
				arr[offSearchIndex] = temp;
				temp = onSearchIndex;// 검색 위치를 전환
				onSearchIndex = offSearchIndex;
				offSearchIndex = temp;
				searchDirection *= -1;// 방향전환
				continue;// 좌>우 방향 검색시작
			}

			onSearchIndex += searchDirection;// 다음 좌검색 위치로 이동
		}
	}
}
