package kr.co.hta.dao;

import kr.co.hta.vo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import kr.co.hta.util.ConnectionUtil;

public class UserDao {
	
	private static final String INSERT_USER_SQL = "INSERT INTO SAMPLE_USERS (USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL) VALUES(?, ?, ?, ?)";
    private static final String GET_USER_BY_ID_SQL = "SELECT * FROM SAMPLE_USERS WHERE USER_ID = ?";
    private static final String UPDATE_USER_SQL = "UPDATE SAMPLE_USERS SET USER_PASSWORD = ?, USER_POINT = ?, USER_DISABLED = ? WHERE USER_ID = ?";
    
    public void insertUser(User user) throws SQLException {
    	Connection con = ConnectionUtil.getConnection();
    	PreparedStatement pstmt = con.prepareStatement(INSERT_USER_SQL);
    	
    	pstmt.setString(1, user.getId());
    	pstmt.setString(2, user.getName());
    	pstmt.setString(3, user.getPassword());
    	pstmt.setString(4, user.getEmail());
    
    	pstmt.executeUpdate();
    	
    	pstmt.close();
    	con.close();
    }
    
    public User getUserById(String userId) throws SQLException {
      User user = null;
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(GET_USER_BY_ID_SQL);
      pstmt.setString(1, userId);
      
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
    	  if (userId == rs.getString(1)) {
    		  User user2 = new User();
    		  String id = rs.getString("USER_ID");
    		  String name = rs.getString("USER_NAME");
    		  String password = rs.getString("USER_PASSWORD");
    		  String email = rs.getString("USER_EMAIL");
    		  Long point = rs.getLong("USER_POINT");
    		  String disabled = rs.getString("USER_DISABLED");
    		  Date createDate = rs.getDate("USER_CREATED_DATE");
    		  
    		  user2.setId(id);
    		  user2.setName(name);
    		  user2.setPassword(password);
    		  user2.setEmail(email);
    		  user2.setPoint(point);
    		  user2.setDisabled(disabled);
    		  user2.setCreateDate(createDate);
    		  
    		  return user2;
    	
    	  }
      }
      rs.close();
      pstmt.close();
      con.close();
      
      return user;
    }
    
    public void updateUser(User user) throws SQLException {
    	Connection con = ConnectionUtil.getConnection();
    	PreparedStatement pstmt = con.prepareStatement(UPDATE_USER_SQL);
    	pstmt.setString(1, user.getPassword() );
    	pstmt.setLong(2, user.getPoint());
    	pstmt.setString(3, user.getDisabled());
    	pstmt.setString(4, user.getId());
    	
    	pstmt.executeUpdate();
    	
    	pstmt.close();
    	con.close();
    }
}
