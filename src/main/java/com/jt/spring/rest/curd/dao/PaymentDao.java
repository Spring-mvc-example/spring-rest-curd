package com.jt.spring.rest.curd.dao;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.spring.rest.curd.entity.Payment;
import com.jt.spring.rest.curd.entity.Response;

@Repository
@Transactional
public class PaymentDao {

	@Autowired
	private SessionFactory factory;

	public Response payNow(Payment payment) {
		getSession().save(payment);
		return new Response(Boolean.TRUE, "Payment success through Vendor :" + payment.getVendorName()
				+ "payment Transaction id " + new Random().nextInt(463837) + " on date " + payment.getPaymentDate());
	}

	@SuppressWarnings("unchecked")
	public List<Payment> getTransactions(String vendor) {
		return getSession().createCriteria(Payment.class).add(Restrictions.eq("vendorName", vendor)).list();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
}
