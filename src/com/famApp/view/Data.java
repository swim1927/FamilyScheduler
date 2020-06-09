package com.famApp.view;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Data implements Serializable{

	private String name; // client�� username�� �����ϴ� ����
	private String receiver; // �Ӹ� �����⿡�� �޼����� ���� user�� name
	private String message; // client�� message�� �����ϴ� ����
	private int state; // client�� ���Ӱ� ������¸� �����ϴ� ����
	
	//�ڷ����� ��ü�̱� ������ skip
	private transient ObjectOutputStream oos;
	private Vector<String> userName;
	//Client�� ó�� ������ �� ���ӵǾ� �ִ� user�� �̸��� �޾ƿö� ����� ������ ���
	
	//client�� ���¸� ��Ÿ�� �� ���� ���
	
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
