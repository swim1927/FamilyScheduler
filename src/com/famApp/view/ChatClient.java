package com.famApp.view;

import java.io.*;
import java.net.*;
import java.util.Vector;
import java.awt.event.*;

public class ChatClient  implements ActionListener, Runnable, ItemListener {

	private final String serverName = "192.168.1.34";
	private final int PORT = 8888;
	String userName;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	private Thread listener;
	private boolean flag;

	private Socket socket;
	private Data d;
	public String chat_txt = "\n";
	public int hour;
	public int min;

	public ChatClient(String userName) {
		this.userName = userName;	}


	public void start() {
		try {
			socket = new Socket(serverName, PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			Data d = new Data(userName, "님이 접속하였습니다 !!!!! ", Data.FIRST_CONNECTION);
			oos.writeObject(d);
			System.out.println("Server에 접속!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		listener = new Thread(this);
		listener.start(); // run() 호출

	}// end start

	
	
	public void run() {
		while (!flag) {
			try {
				d = (Data) ois.readObject();
			} catch (IOException e) {
				System.err.println("run method IOException");
				try {
					oos.close();
					ois.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
				flag = true;
			} catch (ClassNotFoundException e1) {
				System.err.println("Data class NotFound");
			}
			int state = d.getState();
			String name = d.getName();
			System.out.println("name : " + name);
			
			switch (state) {
			case Data.FIRST_CONNECTION:
				Vector<String> UserName = d.getUserName();
				break;

			case Data.DISCONNECTION:
				break;

			default:
				System.out.println("error");

			}// switch
		}// while
		try {
			ois.close();
		} catch (IOException e) {
			System.err
					.println(" ChatClientThread에의 ObjectOutputStream을 Close하는 중에 IOException이 발생하였습니다.");
		}// catch
	}// run


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
