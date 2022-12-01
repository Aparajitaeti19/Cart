package com.example.cart.exceptions;

public class ProductNotExistException extends IllegalArgumentException {
	 public ProductNotExistException(String msg) {
	        super(msg);
	    }
}
