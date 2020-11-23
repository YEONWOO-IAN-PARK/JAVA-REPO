package kr.co.hta.exception;

/**
 * 책정보가 존재하지 않는 경우 던지는 예외이다.
 * @author choes
 *
 */
public class BookNotFoundException extends BookStoreException {
	
	public BookNotFoundException(String message) {
		super(message);
	}
}
