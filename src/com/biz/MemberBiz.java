package com.biz;
import java.sql.*;
import java.util.*;
import com.dao.*;
import com.model.Member;

import static common.JDBCTemplate.*;
//biz : 1. ������� controller���� ����
	//	2. ������� dao�� �����ؼ� ���� ����� controller�� ����
	//	3. ����� ������ dao�� ȣ��. connection & close�� ȣ���ϴ� ��.
public class MemberBiz {


	public int getInsert(Member member) {
		Connection conn = getConnection();
		//controller���� ���� �̸��� dao���� �����ؼ� ������ ���Ϲ޴´�.
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
