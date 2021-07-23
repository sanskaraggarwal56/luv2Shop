package com.gw.ecom.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gw.ecom.dto.Purchase;
import com.gw.ecom.dto.PurchaseResponse;
import com.gw.ecom.entity.Customer;
import com.gw.ecom.entity.Order;
import com.gw.ecom.entity.OrderItem;
import com.gw.ecom.repositories.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		Order order = purchase.getOrder();
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item->order.add(item));
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		Customer customer = purchase.getCustomer();
		customer.add(order);
		customerRepository.save(customer);
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		return UUID.randomUUID().toString();
	}

}
