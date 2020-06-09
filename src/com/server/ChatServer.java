package com.server;

import java.io.*;
import java.net.*;
import java.util.Vector;

import com.famApp.view.Data;

public class ChatServer {
	Vector<Data> buffer;
	ServerSocket serverSocket;
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public void service() {
		try {
			System.out.println("접속 준비중");
			serverSocket = new ServerSocket(8888);
		}catch(IOException e) {
			System.err.println("서비스 준비중에 IOException이 발생했습니다");
		}
		while(true) {
			try {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "가 접속하셨습니다.");
				
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				
				Thread thread = new Thread(new ChatServerThread(buffer, ois, oos));
				thread.start();
			}catch(IOException e) {
				System.err.println("IOException이 발생했습니다.");
				e.printStackTrace();
			}
		}//while
		
	}//service()
	
	public static void main(String[] args) {
		System.out.println("Strat Server Service...");
		ChatServer cs = new ChatServer();
		cs.buffer = new Vector<Data>(5,1);
		cs.service();
		
	}
}
