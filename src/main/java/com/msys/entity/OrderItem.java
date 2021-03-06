package com.msys.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE /* , CascadeType.REFRESH */ })
	@JoinColumn(name = "ID_ARTICLE", nullable = false)
	private Article articles;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST
			/* ,CascadeType.MERGE, CascadeType.REFRESH */ })
	@JoinColumn(name = "ID_ORDER", nullable = false)
	private Order orders;

	@Column(name = "QUANTITY")
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE /* , CascadeType.REFRESH */ })
	@JoinColumn(name = "ID_SUPPLIER", nullable = false)
	private Supplier suppliers;

	public OrderItem() {
	}

	public OrderItem(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order order) {
		this.orders = order;
	}

	public Article getArticles() {
		return articles;
	}

	public void setArticles(Article article) {
		this.articles = article;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Supplier getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Supplier supplier) {
		this.suppliers = supplier;
	}
}
