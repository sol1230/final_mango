package com.mango.final_mango.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mango.final_mango.servlets.Member;

public class MemberDao {

    private Properties prop = new Properties(); 
    
    public int insertMember(Connection conn, Member m) {
		
		System.out.println(m);
		
	
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, m.getUSER_ID());
			pstmt.setString(2, m.getPASSWORD());
			pstmt.setString(3, m.getNAME());
			pstmt.setString(4, m.getPHONE());
			pstmt.setString(5, m.getBIRTH_DATE());
		
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

    private void close(PreparedStatement pstmt) {
    }
	
}
