package kr.co.hta.exception;

/**
 * 책의 재고가 부족할 때 던지는 예외이다.
 * @author choes
 *
 */
public class NotEnoughBookStockException extends BookStoreException {
	
	public NotEnoughBookStockException(String message) {
		super(message);
	}
	
}
