package com.rand.projetomaven.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.rand.projetomaven.domain.enums.PaymentStatus;

@Entity
public class PaymentWithTicket extends Payment {
	private static final long serialVersionUID = 1L;
	private Date duoDate;
	private Date paymentDate;
	
	public PaymentWithTicket() {
		
	}

	public PaymentWithTicket(Integer id, PaymentStatus status, Pedido pedido, Date duoDate, Date paymentDate) {
		super(id, status, pedido);
		this.duoDate = duoDate;
		this.paymentDate = paymentDate;
	}

	public Date getDuoDate() {
		return duoDate;
	}

	public void setDuoDate(Date duoDate) {
		this.duoDate = duoDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
