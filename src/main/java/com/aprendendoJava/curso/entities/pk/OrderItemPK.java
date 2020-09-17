package com.aprendendoJava.curso.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aprendendoJava.curso.entities.Order;
import com.aprendendoJava.curso.entities.Product;

/*
 * anotação utilizada para criar uma classe auxiliar
 * de chave primária composta utliza-se @Embeddable. Essa
 * classe irá auxiliar 
 */
@Embeddable 
public class OrderItemPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	/*
	 * O relacionamento será muitos para um com produto x 
	 * pedido
	 */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	/*
	 * essa classe não terá construtores
	 * será uma tabela de associação entre Order
	 * e Product
	 */
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/*
	 * O hascode utilizou Product e Order
	 * pois os items de pedido deverão ter essas duas informações
	 * então para comparar é necessário essas duas classes
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
	
	

}
