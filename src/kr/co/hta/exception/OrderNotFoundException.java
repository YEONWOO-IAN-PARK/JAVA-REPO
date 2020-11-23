package kr.co.hta.exception;

/**
 * 주문정보를 찾을 수 없을때 던지는 예외이다.
 * @author choes
 *
 */
public class OrderNotFoundException extends BookStoreException {
	
	public OrderNotFoundException(String message) {
		super(message);
	}
	
}
