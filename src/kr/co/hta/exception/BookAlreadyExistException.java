package kr.co.hta.exception;

public class BookAlreadyExistException  extends BookStoreException{
	
	public BookAlreadyExistException(String message) {
		super(message);
	}
}
