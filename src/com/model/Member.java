package com.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Member {

	private final IntegerProperty member_no;
	private final StringProperty member_id;
	private final StringProperty password;
	private final StringProperty family_id;
	private final StringProperty nickname;
	private final ObjectProperty<LocalDate> indate;
	
	/**
	 * 디폴트 생성자
	 */
	public Member() {
		this(null);
	}

	/**
	 * 데이터를 초기화하는 생성자
	 */
	public Member(String member_id) {
		this.member_id = new SimpleStringProperty(member_id);
	
		// 테스트를 위해 초기화하는 더미 데이터
		this.member_no = new SimpleIntegerProperty(0);
		this.password = new SimpleStringProperty();
		this.family_id = new SimpleStringProperty();
		this.nickname = new SimpleStringProperty();
		this.indate = new SimpleObjectProperty<LocalDate>(LocalDate.now());
	}
	
	public int getMember_no() {
		return member_no.get();
	}

	public void setMember_no(int member_no) {
		this.member_no.set(member_no);
	}

	public IntegerProperty member_noProperty() {
		return member_no;
	}
	
	public String getMember_id() {
		return member_id.get();
	}

	public void setMember_id(String member_id) {
		this.member_id.set(member_id);
	}

	public StringProperty member_idProperty() {
		return member_id;
	}
	
	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public StringProperty passwordProperty() {
		return password;
	}
	
	
	public String getFamily_id() {
		return family_id.get();
	}

	public void setFamily_id(String family_id) {
		this.family_id.set(family_id);
	}

	public StringProperty family_idProperty() {
		return family_id;
	}
	
	
	public String getNickname() {
		return family_id.get();
	}

	public void setNickname(String nickname) {
		this.nickname.set(nickname);
	}

	public StringProperty nicknameProperty() {
		return nickname;
	}


	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getIndate() {
	    return indate.get();
	}

	public void setIndate(LocalDate indate) {
		this.indate.set(indate);
	}

	public ObjectProperty<LocalDate> indateProperty() {
		return indate;
	}
}