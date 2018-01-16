package com.jt.spring.rest.curd.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.spring.rest.curd.dao.PaymentDao;
import com.jt.spring.rest.curd.entity.Payment;
import com.jt.spring.rest.curd.entity.Request;
import com.jt.spring.rest.curd.entity.Response;

@RestController
@RequestMapping("/PaymentService")
public class PaymentController {
	@Autowired
	private PaymentDao dao;

	@PostMapping("/pay")
	public Response response(@RequestBody Request<Payment> request) {
		Payment payment = request.getPaymentRequest();
		payment.setPaymentDate(new Date());
		return dao.payNow(payment);
	}

	@GetMapping("/transaction/{vendor}")
	public Response getTransaction(@PathVariable String vendor) {
		List<Payment> payments = dao.getTransactions(vendor);
		Response response = new Response();
		response.setPayments(payments);
		return response;
	}
}
