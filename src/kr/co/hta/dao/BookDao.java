package kr.co.hta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.hta.util.ConnectionUtil;
import kr.co.hta.vo.Book;

public class BookDao {
	private static final String INSERT_BOOK_SQL = 
		"INSERT INTO SAMPLE_BOOKS(BOOK_NO, BOOK_TITLE, BOOK_WRITER, BOOK_GENRE, BOOK_PRICE) VALUES (SAMPLE_BOOK_SEQ.NEXTVAL, ?, ?, ?, ?)";
    private static final String GET_ALL_BOOKS_SQL = 
    	"SELECT * FROM SAMPLE_BOOKS ORDER BY BOOK_NO DESC";
    private static final String GET_BOOK_BY_NO_SQL = 
    	"SELECT * FROM SAMPLE_BOOKS WHERE BOOK_NO = ?";
    private static final String UPDATE_BOOK_SQL = 
    	"UPDATE SAMPLE_BOOKS SET BOOK_TITLE = ?, BOOK_WRITER = ?, BOOK_GENRE = ?, BOOK_PRICE = ?, BOOK_STOCK = ?, BOOK_STATUS = ? WHERE BOOK_NO = ?";
	
    public void insertBook(Book book) throws SQLException {
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(INSERT_BOOK_SQL);
        
        pstmt.setString(2, book.getTitle());
        pstmt.setString(3, book.getWriter());
        pstmt.setString(4, book.getGenre());
        pstmt.setLong(5, book.getPrice());
        
        pstmt.executeUpdate();
        
        pstmt.close();
        con.close();
    }
    
    public List<Book> getAllBooks() throws SQLException {
      List<Book> bookList = new ArrayList<Book>();
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(GET_ALL_BOOKS_SQL);
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
    	  long no = rs.getLong("BOOK_NO");
    	  String title = rs.getString("BOOK_TITLE");
    	  String writer = rs.getString("BOOK_WRITER");
    	  String genre = rs.getString("BOOK_GENRE");
    	  long price = rs.getLong("BOOK_PRICE");
    	  long stock = rs.getLong("BOOK_STOCK");
    	  String status = rs.getString("BOOK_STATUS");
    	  Date createDate = rs.getDate("BOOK_CREATE_DATE");
    	  
    	  Book book = new Book();
    	  book.setNo(no);
    	  book.setTitle(title);
    	  book.setWriter(writer);
    	  book.setGenre(genre);
    	  book.setPrice(price);
    	  book.setStock(stock);
    	  book.setStatus(status);
    	  book.setCreateDate(createDate);
    	  
    	  bookList.add(book);
    	  
      }
      
      rs.close();
      pstmt.close();
      con.close();
      
      return bookList;
    }
    
    public Book getBookByNo(int bookNo) throws SQLException {
      Book book = null;
      Connection con = ConnectionUtil.getConnection();
      PreparedStatement pstmt = con.prepareStatement(GET_BOOK_BY_NO_SQL);
      pstmt.setLong(1, bookNo);
      
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
    	  if(bookNo == rs.getLong(1)) {
    		  Book book2 = new Book();
    		  long no = rs.getLong("BOOK_NO");
        	  String title = rs.getString("BOOK_TITLE");
        	  String writer = rs.getString("BOOK_WRITER");
        	  String genre = rs.getString("BOOK_GENRE");
        	  long price = rs.getLong("BOOK_PRICE");
        	  long stock = rs.getLong("BOOK_STOCK");
        	  String status = rs.getString("BOOK_STATUS");
        	  Date createDate = rs.getDate("BOOK_CREATE_DATE");
        	  
        	  book2.setNo(no);
        	  book2.setTitle(title);
        	  book2.setWriter(writer);
        	  book2.setGenre(genre);
        	  book2.setPrice(price);
        	  book2.setStock(stock);
        	  book2.setStatus(status);
        	  book2.setCreateDate(createDate);
        	  
        	  return book2;
    	  }
      }
      rs.close();
      pstmt.close();
      con.close();
      
      return book;
    }
    
    public void updateBook(Book book) throws SQLException {
    	Connection con = ConnectionUtil.getConnection();
    	PreparedStatement pstmt = con.prepareStatement(UPDATE_BOOK_SQL);
    	
    	pstmt.setString(1, book.getTitle());
    	pstmt.setString(2, book.getWriter());
    	pstmt.setString(3, book.getGenre());
    	pstmt.setLong(4, book.getPrice());
    	pstmt.setLong(5, book.getStock());
    	pstmt.setString(6, book.getStatus());
    	pstmt.setLong(7, book.getNo());
    	
    	pstmt.executeUpdate();
    	
    	pstmt.close();
    	con.close();
    }
}
