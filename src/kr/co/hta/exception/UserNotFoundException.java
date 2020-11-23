package kr.co.hta.exception;

/**
 * 사용자정보를 찾을 수 없을 때 던지는 예외이다.
 * @author choes
 *
 */
public class UserNotFoundException extends BookStoreException {

	public UserNotFoundException(String message) {
		super(message);
	}
}
