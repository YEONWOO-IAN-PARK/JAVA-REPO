package kr.co.hta.exception;

/**
 * 비밀번호가 유효하지 않을때 발생시키는 예외이다.
 * @author choes
 *
 */
public class InvalidPasswordException extends BookStoreException {

	public InvalidPasswordException(String message) {
		super(message);
	}
}
