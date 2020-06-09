package com.dao;

public interface MySql {
	///가입한 회원 디비에 추가
	String member_insert = "BEGIN MEMBER_INSERT(?,?,?,?); END;";
	
	String member_login = "{ ? = call MEMBER_LOGIN(?,?) }";
}


