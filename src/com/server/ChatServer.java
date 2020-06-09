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
			System.out.println("���� �غ���");
			serverSocket = new ServerSocket(8888);
		}catch(IOException e) {
			System.err.println("���� �غ��߿� IOException�� �߻��߽��ϴ�");
		}
		while(true) {
			try {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "�� �����ϼ̽��ϴ�.");
				
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				
				Thread thread = new Thread(new ChatServerThread(buffer, ois, oos));
				thread.start();
			}catch(IOException e) {
				System.err.println("IOException�� �߻��߽��ϴ�.");
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
