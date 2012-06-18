package root.exceptions;

public class UnloggedUserException extends RuntimeException{
	public UnloggedUserException() {
	}
	public UnloggedUserException(String message) {
		super(message);
	}
}
