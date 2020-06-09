package com.famApp.view;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Data implements Serializable{

	private String name; // client의 username을 저장하는 변수
	private String receiver; // 귓말 보내기에서 메세지를 받을 user의 name
	private String message; // client의 message를 저장하는 변수
	private int state; // client의 접속과 종료상태를 저장하는 변수
	
	//자료전달 객체이기 때문에 skip
	private transient ObjectOutputStream oos;
	private Vector<String> userName;
	//Client가 처음 접속할 때 접속되어 있는 user의 이름을 받아올때 사용할 변수와 목록
	
	//client의 상태를 나타낼 때 사용될 상수
	
	public static final int DISCONNECTION = -1;
	public static final int CHAT_MESSAGE = 1;
	public static final int CHAT_WHISPER = 2;
	public static final int FIRST_CONNECTION = 0;
	
	
	public Data() {}
	
	public Data(String name, String message, int state, ObjectOutputStream oos) {
		this.name = name;
		this.message = message;
		this.state = state;
		this.oos = oos;
	}
	

	public Data(String name, String message, int state) {
		this.name = name;
		this.message = message;
		this.state = state;
	}
	
	public Data(String name, String receiver, String message, int state) {
		this.name = name;
		this.receiver = receiver;
		this.message = message;
		this.state = state;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public Vector<String> getUserName() {
		return userName;
	}

	public void setUserName(Vector<String> userName) {
		this.userName = userName;
	}

	
	
}
