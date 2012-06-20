package root.exceptions;

public class UnloggedUserException extends RuntimeException{
	private static final long serialVersionUID = 5146144421147305550L;
	public UnloggedUserException() {
	}
	public UnloggedUserException(String message) {
		super(message);
	}
}
