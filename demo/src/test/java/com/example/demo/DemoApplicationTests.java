package com.example.demo;

import com.example.demo.delivery.*;
import com.example.demo.item.CactusFlower;
import com.example.demo.item.Item;
import com.example.demo.item.RomashkaFlower;
import com.example.demo.payment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void Test() {
        DeliveryController dev = new DeliveryController();
        PaymentController paym = new PaymentController();

        List deliveries = dev.getDelivery();
        Delivery deliveryType1 = (Delivery) deliveries.get(0);
        Delivery deliveryType2 = (Delivery) deliveries.get(1);

        List payments = paym.getPayment();
        Payment paymentType1 = (Payment) payments.get(0);
        Payment paymentType2 = (Payment) payments.get(1);

        NavigateDelivery navDel = new NavigateDelivery();
        navDel.setDeliveryMethod(deliveryType1);
        Assertions.assertEquals(navDel.getDelivery(), deliveryType1);

        NavigatePayment navPaym = new NavigatePayment();
        navPaym.setPaymentMethod(paymentType2);
        Assertions.assertEquals(navPaym.getPayment(), paymentType2);

        navPaym.setPaymentMethod(paymentType1);
        Assertions.assertEquals(navPaym.getPayment(), paymentType1);

        LinkedList items = new LinkedList();
        CactusFlower cactus = new CactusFlower();
        items.add(cactus);
        RomashkaFlower romashka = new RomashkaFlower();
        items.add(romashka);

        navDel.DeliverWithChosenMethod(items);
        for (int i = 0; i < items.size(); ++i) {
            Item itm = (Item) items.get(i);
            navPaym.PayWithChosenMethod(itm.getPrice());
        }
    }
}
