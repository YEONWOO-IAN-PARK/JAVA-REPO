package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.Order;
import kr.co.hta.vo.OrderItem;

public class OrderItemDao {

	private static final String INSERT_ORDER_ITEM_SQL = 
			"INSERT INTO SAMPLE_ORDER_ITEMS (ORDER_NO, BOOK_NO, ORDER_PRICE, ORDER_AMOUNT) VALUES (?, ?, ?, ?)";
    private static final String GET_ORDER_ITEMS_BY_ORDER_NO_SQL =
    		"SELECT * FROM SAMPLE_ORDER_ITEMS WHERE ORDER_NO = ?";
    
    public void insertOrderItem(OrderItem orderItem) throws SQLException {
    	Connection con = ConnectionUtil.getConnection();
    	PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER_ITEM_SQL);
    	pstmt.setLong(1, orderItem.getNo());
    	pstmt.setLong(2, orderItem.getBookNo());
    	pstmt.setLong(3, orderItem.getPrice());
    	pstmt.setLong(4, orderItem.getAmount());
    	pstmt.executeUpdate();
    	
    	pstmt.close();
    	con.close();
    	
    }
    
    public List<OrderItem> getOrderItemsByOrderNo(long orderNo) throws SQLException {
      List<OrderItem> orderList = new ArrayList<OrderItem>();
      Connection con = ConnectionUtil.getConnection();
  	  PreparedStatement pstmt = con.prepareStatement(GET_ORDER_ITEMS_BY_ORDER_NO_SQL);
      pstmt.setLong(1, orderNo);
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
    	if(orderNo == rs.getLong(1)) {
    		OrderItem orderItem = new OrderItem();
    		// 메소드명은 orderItems를 반환한다는데 왜 반환타입이 List<Order>인거죠?
    		long no = rs.getLong("ORDER_NO");
    		long bookNo = rs.getLong("BOOK_NO");
    		long price = rs.getLong("ORDER_PRICE");
    		long amount = rs.getLong("ORDER_AMOUNT");
    		
    		orderItem.setNo(no);
    		orderItem.setBookNo(bookNo);
    		orderItem.setPrice(price);
    		orderItem.setAmount(amount);
    		
    		orderList.add(orderItem);
    	}  
      }
      rs.close();
      pstmt.close();
      con.close();
      
      return orderList;
    }
}
