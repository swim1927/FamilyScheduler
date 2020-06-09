package com.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import com.famApp.view.Data;


public class ChatServerThread implements Runnable {
	Vector<Data> buffer;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Data d;
	boolean exit;
	String name;
	
	public ChatServerThread(Vector<Data> v, ObjectInputStream ois, ObjectOutputStream oos) {
		this.buffer = v;
		this.ois = ois;
		this.oos = oos;
	}

	@Override
	public void run() {
		while (!exit) {
			try {
				d = (Data) ois.readObject(); // 클라이언트 접속시 생성되는 객체
				
				int state = d.getState(); // 클라이언트의 상태를 리턴받는다.
				
				switch (state) {
				case Data.DISCONNECTION :
					name = d.getName();
					for(Data d : buffer) {
						if(d.getName().equals(name)) {
							buffer.removeElement(d);
							//buffer.removeElementAt(i);
							break;
						}//ifk
					}//for
					broadCasting();
					try {
						ois.close();
						oos.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				case Data.FIRST_CONNECTION :
					Vector<String> userName = new Vector<String>(5, 1);
					d.setOos(oos);
					buffer.addElement(d);// 3 +1 4
					for ( Data d: buffer) {
						userName.addElement((d).getName());
					}
					d.setUserName(userName);
					broadCasting();
					break;
				case Data.CHAT_MESSAGE :
					broadCasting();
					break;
				case Data.CHAT_WHISPER :
					whisper();
					break;
				default:
				}
			}catch (Exception e3) {
					System.err.println("ioexception이 발생하였습니다.");
					exit = true;
				}
			}
		}
		
	
	
	public void broadCasting() throws IOException {
		//전체 채팅 회원에게 내용 출력
		for (Data data: buffer) {
			data.getOos().writeObject(d);
			//((Data) buffer.elementAt(i)).getOOS().writeObject(d);
		}
		
	}
	
	public void whisper() {
		
		String receiver = d.getReceiver();//귓말 선택자
		for( Data data : buffer) {
			if (data.getName().equals(receiver)) {
				try {
					data.getOos().writeObject(d);
				} catch (IOException e)
				{
					System.err.println("BroadCasting method에서 Exception이 발생했습니다.");
				}
			}
		}
	}
	
}
