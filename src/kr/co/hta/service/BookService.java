package kr.co.hta.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.hta.dao.BookDao;
import kr.co.hta.exception.BookAlreadyExistException;
import kr.co.hta.vo.Book;

/*
 * 도서관련 서비스(신규도서 등록, 도서 검색, 도서 가격변경, 도서 수량변경)를 제공하는 클래스다.
 * @author choes
 */
public class BookService {

	// SAMPLE_BOOKS와 관련된 DB ACCESS작업이 구현된 BookDao객체 획득하기
	private BookDao bookDao = BookDao.getInstance();
	
	private BookService () {}
	private static BookService bookService = new BookService();
	public static BookService getInstance() {
		return bookService;
	}

	/**
	 * 신규 도서등록 서비스를 제공한다.
	 * @param book 책정보가 저장된 Book객체를 전달받는다.
	 * @throws SQLException
	 */
	public void insertNewBook(Book book) throws SQLException {
		// 새 책정보를 넣으면 무슨 예외를 던져야할까?
		if(bookDao.getBookByNo(book.getNo()) != null) {
			throw new BookAlreadyExistException("["+book.getNo()+"]에 해당하는 책의 정보가 이미 존재합니다.");
		}
		bookDao.insertBook(book);
	}
	
	/**
	 * 등록된 모든 책정보를 제공한다.
	 * @return 모든 책 정보
	 * @throws SQLException
	 */
	public List<Book> getAllBooks() throws SQLException {
		return null;
	}
	
	/**
	 * 제목을 포함하고 있는 모든 책정보를 제공한다.
	 * @param keyword 검색키워드
	 * @return 검색키워드가 제목에 포함된 모든 책 정보
	 * @throws SQLException
	 */
	public List<Book> searchBooksByTitle(String keyword) throws SQLException {
		return null;
	}
	
	/**
	 * 지정된 이름의 저자가 출판한 모든 책정보를 제공한다
	 * @param name 작가이름
	 * @return 해당 작가가 출판한 모든 책 정보
	 * @throws SQLException
	 */
	public List<Book> searchBooksByWriter(String name) throws SQLException {
		return null;
	}
	
	/**
	 * 지정된 가격으로 출판한 모든 책정보를 제공한다
	 * @param minPrice 최소가격
	 * @param maxPrice 최대가격
	 * @return 가격범위에 속하는 모든 책정보
	 * @throws SQLException
	 */
	public List<Book> searchBooksByPrice(int minPrice, int maxPrice) throws SQLException {
		return null;
	}
	
	/**
	 * 
	 * @param bookNo 책번호
	 * @param price 책의 새로운 가격
	 * @throws SQLException
	 */
	public void changeBookPrice(int bookNo, int price) throws SQLException {
		
	}
	
	/**
	 * 책번호에 해당하는 책의 재고를 증가시킨다
	 * @param bookNo 책번호
	 * @param amount 증가량
	 * @throws SQLException
	 */
	public void increaseBookStock(int bookNo, int amount) throws SQLException {
		
	}
	
	/**
	 * 책번호에 해당하는 책의 재고를 감소시킨다
	 * @param bookNo 책번호
	 * @param amount 감소량
	 * @throws SQLException
	 */
	public void decreaseBookStock(int bookNo, int amount) throws SQLException {
		
	}
}
