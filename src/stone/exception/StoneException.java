package stone.exception;

public class StoneException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StoneException() {
		super();
	}

	public StoneException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StoneException(String message, Throwable cause) {
		super(message, cause);
	}

	public StoneException(String message) {
		super(message);
	}

	public StoneException(Throwable cause) {
		super(cause);
	}

}
