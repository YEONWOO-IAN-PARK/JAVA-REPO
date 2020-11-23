package kr.co.hta.exception;

/**
 * 사용자 정보가 이미 존재하는 경우 던지는 예외다.
 * @author choes
 *
 */
public class UserAlreadyExistException extends BookStoreException{
	
	public UserAlreadyExistException(String message) {
		super(message);
	}
}
