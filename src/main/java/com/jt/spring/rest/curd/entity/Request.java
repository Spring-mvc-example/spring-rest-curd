package com.jt.spring.rest.curd.entity;

public class Request<T> {

	private T paymentRequest;

	public T getPaymentRequest() {
		return paymentRequest;
	}

	public void setPaymentRequest(T paymentRequest) {
		this.paymentRequest = paymentRequest;
	}

}
