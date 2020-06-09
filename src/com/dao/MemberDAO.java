package com.dao;

import oracle.jdbc.*;
import static common.JDBCTemplate.*;

import com.model.Member;

import java.sql.*;
import java.util.*; //List<MyEmpVo> ��ü

//CRUD �޼��常 �����Ѵ�.
//view -> controller -> model[biz] connection & close -> dao
public class MemberDAO implements MySql{
	private Connection conn;
	public MemberDAO(Connection conn) {
		this.conn=conn;
	} // ������ ���¸� �̷��� �޾� ��.
	
	/////////////insert
	public int getInsert(Member member) {
		int res = 0;
		CallableStatement Pstmt = null;
		try {
			Pstmt = conn.prepareCall(member_insert); // ����ȣ��
			
			Pstmt.setString(1, member.getMember_id());
			Pstmt.setString(2, member.getPassword());
			Pstmt.setString(3, member.getFamily_id());
			Pstmt.setString(4, member.getNickname());
			Pstmt.execute();
			Commit(conn);
			
			//������ �����Ѵ�
			/*
			 * res = Pstmt.executeUpdate(); if (res>0) { System.out.println("�Է¼���");
			 * Commit(conn); }
			 */
		}catch (Exception e) {
			Rollback(conn);
		} finally {
			Close(Pstmt);
		}
		return res;
	}
	
	
	/////////////LOGIN
	public int getLogIn(Member member) {
	int rs = 0;
	CallableStatement cstmt =null;
	try {
		cstmt = conn.prepareCall(member_login);
        cstmt.setQueryTimeout(1800);
        cstmt.setString(2, member.getMember_id());
        cstmt.setString(3, member.getPassword());
        cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cstmt.executeUpdate();
        rs = cstmt.getInt(1);
        Commit(conn);
	}catch (Exception e) {
		Rollback(conn);
	} finally {
		Close(cstmt);
	}
	return rs;
	}

	
}//class end
