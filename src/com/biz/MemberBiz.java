package com.biz;
import java.sql.*;
import java.util.*;
import com.dao.*;
import com.model.Member;

import static common.JDBCTemplate.*;
//biz : 1. 계산결과를 controller에게 리턴
	//	2. 계산결과를 dao로 연결해서 수행 결과를 controller로 리턴
	//	3. 계산이 없으면 dao를 호출. connection & close를 호출하는 곳.
public class MemberBiz {


	public int getInsert(Member member) {
		Connection conn = getConnection();
		//controller에게 받은 이름을 dao에게 전달해서 정보를 리턴받는다.
		int res = new MemberDAO(conn).getInsert(member);
		Close(conn);
		return res;
	}
	
	public int getLogIn(Member member) {
		Connection conn = getConnection();
		int rs = new MemberDAO(conn).getLogIn(member);
		Close(conn);
		return rs;
	}

	
}
