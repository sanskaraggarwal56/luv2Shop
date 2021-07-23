package com.gw.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gw.ecom.dto.Purchase;
import com.gw.ecom.dto.PurchaseResponse;
import com.gw.ecom.service.CheckoutService;

@CrossOrigin("http://localhost:4100")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		
		PurchaseResponse purchaseRespose = checkoutService.placeOrder(purchase);
		return purchaseRespose;
	}
}
