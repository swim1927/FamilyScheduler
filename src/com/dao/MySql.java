package com.dao;

public interface MySql {
	///������ ȸ�� ��� �߰�
	String member_insert = "BEGIN MEMBER_INSERT(?,?,?,?); END;";
	
	String member_login = "{ ? = call MEMBER_LOGIN(?,?) }";
}


