package com.gw.ecom.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Set<Order> orders = new HashSet<Order>();
	
	public void add(Order order) {
		if(order!=null) {
			if(this.orders ==null) {
				this.orders =new HashSet<Order>();
			}
			
			this.orders.add(order);
			order.setCustomer(this);
		}
	}
	
}

