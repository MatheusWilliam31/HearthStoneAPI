package br.com.HearthStoneAPI.resources.exceptions;

public class CartaNotfoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public CartaNotfoundException(String msg) {
		super(msg);
	}

}
