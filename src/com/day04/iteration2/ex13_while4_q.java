package com.day04.iteration2;

public class ex13_while4_q {

	public static void main(String[] args) {
		String s;
		StringBuffer clap = new StringBuffer();
		StringBuffer result = new StringBuffer();
		for(int i=1;i<=50;i++) {
			s = String.valueOf(i);
			for(int j=0;j<s.length();j++) {
				if( s.charAt(j)=='3'||
					s.charAt(j)=='6'||
					s.charAt(j)=='9')
				{
					clap.append('짝');
				}
			}
			
			if(clap.length()>0) {
				result.append(clap);
				clap.delete(0, clap.length());
			}else {
				result.append(s);
			}
			result.append('\n');
		}
		
		System.out.println(result);
	}

}
