package com.dao;

import oracle.jdbc.*;
import static common.JDBCTemplate.*;

import com.model.Member;

import java.sql.*;
import java.util.*; //List<MyEmpVo> 객체

//CRUD 메서드만 존재한다.
//view -> controller -> model[biz] connection & close -> dao
public class MemberDAO implements MySql{
	private Connection conn;
	public MemberDAO(Connection conn) {
		this.conn=conn;
	} // 연결한 상태를 이렇게 받아 옴.
	
	/////////////insert
	public int getInsert(Member member) {
		int res = 0;
		CallableStatement Pstmt = null;
		try {
			Pstmt = conn.prepareCall(member_insert); // 쿼리호출
			
			Pstmt.setString(1, member.getMember_id());
			Pstmt.setString(2, member.getPassword());
			Pstmt.setString(3, member.getFamily_id());
			Pstmt.setString(4, member.getNickname());
			Pstmt.execute();
			Commit(conn);
			
			//쿼리를 실행한다
			/*
			 * res = Pstmt.executeUpdate(); if (res>0) { System.out.println("입력성공");
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
