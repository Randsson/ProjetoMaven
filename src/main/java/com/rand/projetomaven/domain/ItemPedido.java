package com.rand.projetomaven.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double descont;
	private Integer quantity;
	private Double price;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Product product,  Double descont, Integer quantity, Double price) {
		super();
		id.setPedido(pedido);
		id.setProduct(product);
		this.descont = descont;
		this.quantity = quantity;
		this.price = price;
	}
	
	public double getSubTotal() {
		return (price -  descont) * quantity;
	}
		
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDescont() {
		return descont;
	}

	public void setDescont(Double descont) {
		this.descont = descont;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
