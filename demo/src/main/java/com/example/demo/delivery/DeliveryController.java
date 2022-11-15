package com.example.demo.delivery;

import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;
import com.example.demo.payment.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/api/vi/delivery")
public class DeliveryController {
    @GetMapping
    public List<? extends Delivery> getDelivery() {
        return Arrays.asList(new DHLDeliveryStrategy(), new PostDeliveryStrategy());
    }
}
