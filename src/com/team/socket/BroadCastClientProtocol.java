package com.team.socket;

import java.io.Serializable;

public class BroadCastClientProtocol implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4081238907505627020L;
	// 클라이언트에서 서버로 전송시 상태값

	public static final int CHATTING = 200; // 챗팅메세지
	public static final int PACKET = 300;//패킷 전송
//	public static final int SEND_ID = 300; // 처음 접속시 아이디
//	public static final int EXIT = 400; // 접속을 끊을때
//
//	public static final int REQUEST_GAME = 0;
//	public static final int VIEW_GAME = 1;

//	public static final int SET_BADUK_ROCK = 11;

	Object data;
	int state;

	public BroadCastClientProtocol(){
	}

	public void setData(Object obj) {
		data = obj;
	}

	public void setState(int s) {
		state = s;
	}

	public Object getData() {
		return data;
	}

	public int getState() {
		return state;
	}
}
