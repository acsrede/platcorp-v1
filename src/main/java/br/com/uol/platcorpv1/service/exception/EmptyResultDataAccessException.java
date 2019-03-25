package br.com.uol.platcorpv1.service.exception;

public class EmptyResultDataAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyResultDataAccessException(String msg) {
		super(msg);
	}

	public EmptyResultDataAccessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}