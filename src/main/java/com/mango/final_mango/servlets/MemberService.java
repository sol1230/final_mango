package com.mango.final_mango.servlets;

import java.sql.Connection;

import com.mango.final_mango.dao.MemberDao;

public class MemberService {
    public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
}
