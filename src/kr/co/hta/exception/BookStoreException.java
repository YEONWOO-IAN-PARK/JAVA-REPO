package kr.co.hta.exception;

/**
 * BookStore 프로젝트의 최상위 예외클래스이다.
 * @author choes
 *
 */
public class BookStoreException extends RuntimeException {
	
	public BookStoreException(String message) {
		super(message);
	}
}
