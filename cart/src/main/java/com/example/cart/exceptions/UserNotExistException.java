package com.example.cart.exceptions;

public class UserNotExistException extends IllegalArgumentException {
	 public UserNotExistException(String msg) {
	        super(msg);
	    }

}
