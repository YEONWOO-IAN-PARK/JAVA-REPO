package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.Order;

public class OrderDao {

	private static final String GET_NEW_ORDER_NO_SQL = "SELECT SAMPLE_ORDER_SEQ.NEXTVAL AS ORDERNO FROM DUAL";
    private static final String INSERT_ORDER_SQL = "INSERT INTO SAMPLE_ORDERS (ORDER_NO, USER_ID, ORDER_STATUS) VALUES (?, ?, ?, ?)";
    private static final String GET_ORDERS_BY_USER_ID_SQL = "SELECT * FROM SAMPLE_ORDERS WHERE USER_ID = ?";
    private static final String GET_ORDER_BY_NO_SQL = "SELECT * FROM SAMPLE_ORDERS WHERE ORDER_NO = ?";
    private static final String UPDATE_ORDER_SQL = "UPDATE SAMPLE_ORDERS SET ORDER_STATUS = ? WHERE ORDER_NO = ?";
    
    public int getNewOrderNo() throws SQLException {
      int orderNo = 0;
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(GET_NEW_ORDER_NO_SQL);
      ResultSet rs = pstmt.executeQuery();
      // 모르겠다..정말
     
      
      return orderNo;
    }
    
    public void insertOrder(Order order) throws SQLException {
    	Connection con = ConnectionUtil.getConnection();
    	PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER_SQL);
    	pstmt.setLong(1, order.getNo());
    	pstmt.setString(2, order.getUserId());
    	pstmt.setString(3, order.getStatus());
    	
    	pstmt.executeUpdate();
    	
    	pstmt.close();
    	con.close();
    	
    }
    
    public List<Order> getOrdersByUserId(String userId) throws SQLException {
      List<Order> orderList = new ArrayList<Order>();
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(GET_ORDERS_BY_USER_ID_SQL);
      pstmt.setString(1, userId);
      
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
    	  if(userId.equals(rs.getString(1))) {
    		  Order order = new Order();
    		  Long no = rs.getLong("ORDER_NO");
    		  String id = rs.getString("USER_ID");
    		  String status = rs.getString("ORDER_STATUS");
    		  Date createDate = rs.getDate("ORDER_CREATE_DATE");
    		  
    		  order.setNo(no);
    		  order.setUserId(id);
    		  order.setStatus(status);
    		  order.setCreateDate(createDate);
    		  
    		  orderList.add(order);
    	  }
      }
      rs.close();
      pstmt.close();
      con.close();
      
      return orderList;
    }
    
    public Order getOrderByNo(long orderNo) throws SQLException {
      Order order = null;
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(GET_ORDER_BY_NO_SQL);
      pstmt.setLong(1, orderNo);
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
    	  if(orderNo == rs.getLong(1)) {
    		  Order order2 = new Order();
    		  Long no = rs.getLong("ORDER_NO");
    		  String id = rs.getString("USER_ID");
    		  String status = rs.getString("ORDER_STATUS");
    		  Date createDate = rs.getDate("ORDER_CREATE_DATE");
    		  
    		  order2.setNo(no);
    		  order2.setUserId(id);
    		  order2.setStatus(status);
    		  order2.setCreateDate(createDate);
    		  
    		  return order2;
    	  }
      }
      rs.close();
      pstmt.close();
      con.close();
      
      return order;
    }
    
    public void updateOrder(Order order) throws SQLException {
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(UPDATE_ORDER_SQL);
      pstmt.setString(1, order.getStatus());
      pstmt.setLong(2, order.getNo());
      pstmt.executeUpdate();
      
      pstmt.close();
      con.close();
    }
}
