package com.rand.projetomaven.domain;

import javax.persistence.Entity;

import com.rand.projetomaven.domain.enums.PaymentStatus;

@Entity
public class PaymentWithCCard extends Payment {
	private static final long serialVersionUID = 1L;
	private Integer installmentQty;
	
	public PaymentWithCCard() {
		
	}

	public PaymentWithCCard(Integer id, PaymentStatus status, Pedido pedido, Integer installmentQty) {
		super(id, status, pedido);
		this.installmentQty = installmentQty;
	}

	public Integer getInstallmentQty() {
		return installmentQty;
	}

	public void setInstallmentQty(Integer installmentQty) {
		this.installmentQty = installmentQty;
	}
	
}
