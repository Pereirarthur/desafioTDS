package com.desafio.services.exceptions;

public class ChaveErradaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ChaveErradaException (String msg) {
		super(msg);
	}
	
	public ChaveErradaException (String msg, Throwable cause) {
		super (msg, cause);
	}
}
