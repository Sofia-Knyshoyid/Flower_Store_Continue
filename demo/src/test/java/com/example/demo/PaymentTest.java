package com.example.demo;

import com.example.demo.delivery.*;
import com.example.demo.payment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class PaymentTest {
    @Test
    void TestPayment(){
        PaymentController paym = new PaymentController();
        List var = paym.getPayment();

        Random rand = new Random();
        int randidx = rand.nextInt(var.size());
        Payment paymentType = (Payment) var.get(randidx);
        Assertions.assertEquals((paymentType instanceof CreditCardPaymentStrategy) || (paymentType instanceof PayPalPaymentStrategy), true);
        Assertions.assertEquals(paymentType instanceof Payment, true);

        NavigatePayment nav = new NavigatePayment();
        nav.setPaymentMethod(paymentType);
        Assertions.assertEquals(nav.getPayment(), paymentType);
    }
}
