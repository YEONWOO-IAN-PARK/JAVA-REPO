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
    private static final String INSERT_ORDER_SQL = "INSERT INTO SAMPLE_ORDERS (ORDER_NO, USER_ID, ORDER_STATUS) VALUES (?, ?, ?)";
    private static final String GET_ORDERS_BY_USER_ID_SQL = "SELECT * FROM SAMPLE_ORDERS WHERE USER_ID = ?";
    private static final String GET_ORDER_BY_NO_SQL = "SELECT * FROM SAMPLE_ORDERS WHERE ORDER_NO = ?";
    private static final String UPDATE_ORDER_SQL = "UPDATE SAMPLE_ORDERS SET ORDER_STATUS = ? WHERE ORDER_NO = ?";
    
    // 싱글턴 객체로 만든기(생성자 은닉화, 정적변수에 객체담기, 객체를 제공하는 정적메소드 정의하기)
    private OrderDao () {}
    private static OrderDao orderDao = new OrderDao();
    public static OrderDao getInstance() {
    	return orderDao;
    }
    
    public long getNewOrderNo() throws SQLException {
      long orderNo = 0;
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(GET_NEW_ORDER_NO_SQL);
      ResultSet rs = pstmt.executeQuery();
      // 모르겠다..정말
     if(rs.next()) {
    	 orderNo = rs.getLong("ORDERNO");
    	 
     }
      rs.close();
      pstmt.close();
      con.close();
      
      return orderNo;
    }
   
    /**
     * 주문정보를 저장한다
     * @param order 새 주문정보
     * @throws SQLException
     */
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
    	  Order order2 = new Order();
    	  order2.setNo(rs.getLong("ORDER_NO"));
    	  order2.setUserId(rs.getString("USER_ID"));
    	  order2.setStatus(rs.getString("ORDER_STATUS"));
    	  order2.setCreateDate(rs.getDate("ORDER_CREATE_DATE"));
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
