import java.util.Locale;

import com.tri.printer.*;

public class Hello {
	
	public static PrintTri pt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world!!");
		System.out.println("안녕 세계야!!");
		System.out.printf(Locale.KOREAN, "프린트에프입니다. %d %s", 10,"살 입니다." );
		int color3 = 1;
		int abcdefghijklmnopqrstuvwxyz = 1;
//		int color-number = 1;
		int $this = 1;
		
		pt = new PrintTri();		
	}
}
