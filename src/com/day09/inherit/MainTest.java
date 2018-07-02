package com.day09.inherit;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Umma u = new Umma();
		u.gene();
		u.job();
		
		Ddal d = new Ddal();
		d.gene();
		d.study();
		d.job();//부모메소드 접근가능
		
		//부모변수에 자식저장 가능
		Umma dal = new Ddal();
		dal.job();
		dal.gene();//overriding
		//dal.study();//Umma 객체이므로 Ddal 메소드 호출불가
		
		// instanceof 객체 여부 확인
		
		if( dal instanceof Ddal)
			System.out.println("딸객체임");
		if( dal instanceof Umma)
			System.out.println("엄마객체임");
//		if( dal instanceof String)//상속 관계없으면 컴파일 애러
//			System.out.println("딸객체임");
		if( dal instanceof Object)//Object 클래스는 java 루트격 클래스
			System.out.println("딸객체임");
		
		//형변환: casting 연산자 사용 ex) (데이터형)변수
		//-기본형끼리
		//-상속관계시
		
//		String a = "hello";
//		StringBuffer sb = (StringBuffer)a;//상속관계 아니므로 불가능
		
//		Umma a = new Umma();
//		Ddal b = (Ddal)a;//실행시 예외발생
		
		Ddal c = new Ddal();
		Umma d1 = (Umma)c;//up-casting: 자식객체를 부모객체로 형변환
		Ddal e = (Ddal)d1;//down-casting: 부모객체를 자식객체로 형변환
		
		
	}

}
