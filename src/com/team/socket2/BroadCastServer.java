package com.team.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BroadCastServer implements Runnable {
	ServerSocket ss;	
	ArrayList<BroadCastChatService> cl;
	
	int tcpPORT = 5000;
	int udpPORT = 3001;
	
	@Override
	public void run() {
		try {
			ss = new ServerSocket(tcpPORT);
			System.out.println("접속대기중:"+ss);
		} catch (IOException e) {
			e.printStackTrace();
		}
		cl = new ArrayList<BroadCastChatService>();
		
		while(true) {
			try {
				Socket s = ss.accept();
				System.out.println("접속중:"+s);
				BroadCastChatService bs = new BroadCastChatService(s);
				bs.start();
				cl.add(bs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class BroadCastChatService extends Thread{
		
		String myname = "guest";
		BufferedReader in;
		OutputStream out;
		
		public BroadCastChatService(Socket s) {
			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				out = s.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			while(true) {
				try {
					String msg = in.readLine();
					if(msg == null) return;
					System.out.println("msg: "+msg);
					putMessageAll(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
		}
		void putMessageAll( String msg ) {
			for( int i =0 ; i<cl.size() ; i++ ) {
				BroadCastChatService cs = ( BroadCastChatService ) cl.get(i);
				
				try {
					cs.putMessage(msg);
				}catch( Exception e ) {
					cl.remove(i--);
				}
			}
		}
		void putMessage( String msg ) throws Exception {
			out.write( (msg+"\r\n").getBytes() );
		}	
	}
	
	public static void main(String[] args) {
		new Thread(new BroadCastServer()).start();
	}

}
