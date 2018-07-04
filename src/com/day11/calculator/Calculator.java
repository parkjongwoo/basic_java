package com.day11.calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * 입력버튼 글자모음
	 */
	private String[] controlMenuTitle = { "1","2","3","4","5","6","7","8","9","+","0","=","-","*","/" };
	/**
	 * 입력버튼 매핑 리스트
	 */
	private Map<String, JButton> controlMenuButtonMap = new HashMap<String, JButton>();
	/**
	 * 입력창
	 */
	private JTextField inputField;
	/**
	 * 계산기 전체 포함 컨테이너
	 */
	private JPanel mainPanel;
	
	/**
	 * 버튼을 인덱스 값으로 찾기
	 * @param itemIndex 버튼 글자의 인덱스 값.controlMenuTitle의 순번과 동일.
	 * @return JButton 객체. 글자 입력 버튼.
	 */
	private JButton getButtonFromeControlMenuByIndex(int itemIndex) {
		return getButtonFromeControlMenuByTitle(controlMenuTitle[itemIndex]);
	}
	/**
	 * 버튼 글자로 버튼 찾기
	 * @param title 버튼에 포함된 라벨 텍스트
	 * @return JButton 객체. 글자 입력 버튼.
	 */
	private JButton getButtonFromeControlMenuByTitle(String title) {
		return controlMenuButtonMap.get(title);
	}
	
	/**
	 * 전체 레이아웃 생성
	 * @return JPanel 전체 레이아웃 포함한 컨테이너
	 */
	private JPanel buildMain() {
		JPanel p = new JPanel(new BorderLayout());
		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(300, 150));
		
		p.add(inputField, BorderLayout.NORTH);//입력창 추가
		p.add(buildControlMenu(), BorderLayout.SOUTH);//입력버튼 모음 추가
		return p;
	}
	
	/**
	 * 글자 입력 버튼 UI 작성.
	 * @return JPanel 입력 버튼 포함 컨테이너.
	 */
	private JPanel buildControlMenu() {
		JPanel p = new JPanel(new GridLayout(5,3));
		p.setPreferredSize(new Dimension(300, 400));
		JButton b;
		for (int i = 0; i < controlMenuTitle.length; i++) {// 버튼 글자수만큼 반복
			b = new JButton(controlMenuTitle[i]);//버튼생성
			b.setMnemonic((i + 1));
			controlMenuButtonMap.put(controlMenuTitle[i], b);//차후 참조위해 매핑
			p.add(b);
		}
		return p;
	}
	
	/**
	 * textField에 기존 글자에 덧붙여 글자 추가
	 * @param tf 글자를 추가할 textField
	 * @param addedString 추가할 글자
	 */
	private void addText(JTextField tf, String addedString) {		
		String oldStr = tf.getText();
		String newStr = oldStr + addedString;
		tf.setText(newStr);
	}
	
	/**
	 * 입력된 수식을 계산
	 * @param expression
	 * @return 수식의 계산결과
	 */
	private String calculate(String expression) {		
		LinkedList<String> postfix = changeFromInfixToPostFix(expression);//후위 연산으로 변경
		return calculatePostfix(postfix);//후위 연산을 계산
	}	
	
	/**
	 * 후위 연산으로 변경된 수식을 계산
	 * @param postfix 후위연산으로 변경한 수식
	 * @return 수식의 계산결과
	 */
	private String calculatePostfix(LinkedList<String> postfix) {
		Stack<String> opStack = new Stack<String>();
		String item;
		while(!postfix.isEmpty()) {// 후위 연산식이 남아있으면
			item = postfix.removeFirst();//첫 항 가져오기
			if(isDouble(item)) {//숫자라면
				opStack.push(item);//스택에 저장
			}else {//숫자가 아니면
				opStack.push(getCalculateResult(opStack.pop(),opStack.pop(),item));//연산자에 맞춰 마지막 숫자항, 마지막-1 숫자항을 연산
			}
		}
		return opStack.pop();		
	}
	
	/**
	 * 좌,우항과 연산자를 문자열로 받아 계산 결과 문자로 반환
	 * @param right 우항
	 * @param left 좌항
	 * @param operator 연산자
	 * @return 연산결과
	 */
	private String getCalculateResult(String right, String left, String operator) {
		double leftValue = Double.valueOf(left); //왼쪽항에 넣을 Double
		double rightValue = Double.valueOf(right);//오른쪽항에 넣을 Double
		double result = 0.0;
		
		switch(operator.charAt(0)) {//연산자 첫글자가 각 연산자에 맞춰 작업
		case '*':
			result = leftValue * rightValue;
			break;			
		case '/':
			result = leftValue / rightValue;
			break;			
		case '+':
			result = leftValue + rightValue;
			break;			
		case '-':
			result = leftValue - rightValue;
			break;
			
		}
		return String.valueOf(result);
	}
	
	/**
	 * 중위 연산 수식을 후위 연산 수식으로 변경
	 * @param s String 중위 연산 수식
	 * @return LinkedList<String> 후위 연산으로 변경된 수식을 각 항단위로 분리 저장
	 */
	private LinkedList<String> changeFromInfixToPostFix(String s) {
		LinkedList<String> postfix = new LinkedList<String>();//결과로 반환할 큐.
		StringBuffer sb = new StringBuffer();//숫자항을 한자리씩 합쳐 생성할 문자열
		Stack<Character> operatorStack = new Stack<Character>();//연산자만 저장하는 스택
		char thisChar = ' ';
		for(int i=0;i<s.length();i++) {//수식 문자열 갯수만큼 반복
			thisChar = s.charAt(i);//이번 작업할 문자
			if(thisChar>='0' && thisChar<='9') {//숫자면
				sb.append(s.charAt(i));			//숫자생성에 추가
			}else {//연산자라면
				postfix.add(sb.toString());//숫자 항이 완성되었으므로 결과 큐에 저장
				sb.setLength(0);//숫자생성 리셋
				if(operatorStack.empty()) {//연산자 스택이 비었으면
					operatorStack.push(thisChar);//연산자 스택에 연산자 저장
				}else {//기존 저장한 연산자가 있다면
					if(getOperatorPriority(operatorStack.peek())<getOperatorPriority(thisChar)) {//이번 연산자의 우선순위가 기존 저장한 연산자보다 높다면
						operatorStack.push(thisChar);//이번연산자를 스택에 저장
					}else if(getOperatorPriority(operatorStack.peek())==getOperatorPriority(thisChar)){//이번,기존 연산자 우선순위가 같다면
						postfix.add(operatorStack.pop().toString());//기존 연산자를 결과 큐에 저장
						operatorStack.push(thisChar);//연산자 스택에 이번 연산자 저장
					}else {//기존 연산자의 우선순위가 높으면
						addAllStackToList(operatorStack, postfix);//모든 연산자 스택의 요소를 큐에 저장
						operatorStack.push(thisChar);//이번 연산자를 연산자 스택에 저장
					}
				}
			}
		}
		postfix.add(sb.toString());// 숫자항으로 수식이 끝나므로 숫자 생성의 남은 숫자항을 추가한다.
		addAllStackToList(operatorStack, postfix);	//남은 연산자 스택의 연산자를 결과 큐에 저장
		return postfix;
	}
	
	/**
	 * 스택의 모든 값을 큐에 이전
	 * @param operatorStack 값을 pop할 스택
	 * @param postfix 값을 저장할 큐
	 */
	private void addAllStackToList(Stack<Character> operatorStack, LinkedList<String> postfix) {
		while(!operatorStack.empty()) {
			postfix.add(operatorStack.pop().toString());
		}
	}
	
	/**
	 * 연산자 우선도 지정
	 * @param operator 연산자
	 * @return *, /는 우선 순위 1, 나머지(+,-)는 0.
	 */
	private int getOperatorPriority(char operator) {
		if(operator=='*' || operator=='/')
			return 1;
		else
			return 0;
	}
	
	/**
	 * 문자열이 Double로 형변환 가능한지 체크
	 * @param str 체크할 문자열
	 * @return 형변환 가능여부
	 */
	private boolean isDouble(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {//-부호가 문자열 첫 글자 이면
	        if (length == 1) {// -단독 char 이면 숫자아님
	            return false;
	        }
	        i = 1;
	    }
	    int pointCnt = 0;
	    while (i < length) {
	        char c = str.charAt(i);//문자열중
	        if (c < '0' || c > '9' ) {//숫자값이 아닌 글자라면
	        	if(c != '.') {//점.이 아니면 숫자 아님
	        		return false;
	        	}else {// 글자중 점이 오면
	        		if(pointCnt==0) {//첫 점은 무시
	        			pointCnt++;
	        		}else {
	        			return false;
	        		}	        		
	        	}	        	
	        }
	        i++;
	    }
	    return true;
	}
	
	/**
	 * 레이아웃추가
	 */
	public void addLayout() {
		mainPanel = buildMain();

		add(mainPanel);
		setSize(300, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * =로 결과확인 및 입력창 초기화.
	 */
	public void addEvent() {
		for(int i=0;i<controlMenuTitle.length;i++) {
			getButtonFromeControlMenuByIndex(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {					
					String expression = inputField.getText();//입력창에 있는 문자열 전체
					if(expression.indexOf('=')>=0) {//입력창에 =이 있다면 이미 계산 완료 
						inputField.setText("");//입력 초기화
					}
					JButton jb = (JButton)e.getSource();
					String inputString = jb.getText();
					if(inputString.equals("=")) {//=키 누른경우
						String result = calculate(expression);//결과값 산정
						addText(inputField, "=");//textField에 =추가
						addText(inputField, result);//	수식마지막에 답 추가
					}else {//=이외의 키 누르면
						addText(inputField, inputString);//입력한 글자 입력창에 입력
					}
				}
			});			
		}
	}
}
