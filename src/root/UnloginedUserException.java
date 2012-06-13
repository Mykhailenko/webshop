package root;

public class UnloginedUserException extends RuntimeException{
	public UnloginedUserException(String message) {
		super(message);
	}
}
