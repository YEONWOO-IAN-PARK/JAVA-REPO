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
    
    // 싱글턴 객체로 만든기(생성자 은닉화, 정적변수에 객체담기, 객체를 제공하는 정적메소드 정의하기)
    private OrderItemDao() {}
    private static OrderItemDao orderItemDao = new OrderItemDao();
    public static OrderItemDao getInstance() {
    	return orderItemDao;
    }
    
    /**
     * 주문 상품정보를 저장한다.
     * @param orderItem 
     * @throws SQLException
     */
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
    		OrderItem orderItem = new OrderItem();
    		// 메소드명은 orderItems를 반환한다는데 왜 반환타입이 List<Order>인거죠?		
    		orderItem.setNo(rs.getLong("ORDER_NO"));
    		orderItem.setBookNo(rs.getInt("BOOK_NO"));
    		orderItem.setPrice(rs.getInt("ORDER_PRICE"));
    		orderItem.setAmount(rs.getInt("ORDER_AMOUNT"));
    	
    		orderList.add(orderItem);
      }
      rs.close();
      pstmt.close();
      con.close();
      
      return orderList;
    }
}
