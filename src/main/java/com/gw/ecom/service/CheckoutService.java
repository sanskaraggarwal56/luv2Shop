package com.gw.ecom.service;

import com.gw.ecom.dto.Purchase;
import com.gw.ecom.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
