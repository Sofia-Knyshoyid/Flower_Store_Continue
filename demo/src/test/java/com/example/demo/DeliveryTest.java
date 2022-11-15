package com.example.demo;

import com.example.demo.delivery.*;
import com.example.demo.payment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class DeliveryTest {
    @Test
    void TestDelivery() {
        DeliveryController dev = new DeliveryController();
        List var = dev.getDelivery();

        Random rand = new Random();
        int randidx = rand.nextInt(var.size());
        Delivery deliveryType = (Delivery) var.get(randidx);
        Assertions.assertEquals((deliveryType instanceof DHLDeliveryStrategy) || (deliveryType instanceof PostDeliveryStrategy), true);
        Assertions.assertEquals(deliveryType instanceof Delivery, true);

        NavigateDelivery nav = new NavigateDelivery();
        nav.setDeliveryMethod(deliveryType);
        Assertions.assertEquals(nav.getDelivery(), deliveryType);
    }
}
