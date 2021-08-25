package pl.michalzadrozny.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7898088037447026312L;

	public NotFoundException(String message) {
		super(message);
	}
}
