package kr.co.hta.exception;

/**
 * 비밀번호가 일치하지 않는 경우 던지는 예외
 * @author choes
 *
 */
public class PasswordMismatchException extends RuntimeException{

	public PasswordMismatchException(String message) {
		super(message);
	}
}
