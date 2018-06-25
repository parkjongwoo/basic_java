package z_useful;

public class SpeedMain {
	public static void main(String[] args) {
		
//		String 클래스 처리속도
		
		String  str = "";
		long currentTime = System.currentTimeMillis();
		
		for(int i=0;i<50000;i++) {
			str = str + "A";
		}
		
		long elapsedTime = System.currentTimeMillis()-currentTime;
		System.out.println("str:"+str);
		System.out.println("String elapsedTime:"+elapsedTime);
		
		
//		StringBuilder 클래스 처리속도
		StringBuilder sb = new StringBuilder("");
		currentTime = System.currentTimeMillis();
		for(int i=0;i<50000;i++) {
			sb.append("A");
		}
		elapsedTime = System.currentTimeMillis()-currentTime;
		System.out.println("sb:"+sb.toString());
		System.out.println("StringBuilder elapsedTime:"+elapsedTime);
	}
	
	
}
