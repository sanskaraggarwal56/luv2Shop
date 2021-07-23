package com.gw.ecom.dto;

import java.util.Set;

import com.gw.ecom.entity.Address;
import com.gw.ecom.entity.Customer;
import com.gw.ecom.entity.Order;
import com.gw.ecom.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

	private Customer customer;
	
	private Address billingAddress;
	
	private Address shippingAddress;
	
	private Order order;
	
	private Set<OrderItem> orderItems;
}
