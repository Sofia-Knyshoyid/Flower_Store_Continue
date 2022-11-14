package com.example.demo.order;

import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.NavigateDelivery;
import com.example.demo.item.Item;
import com.example.demo.payment.NavigatePayment;
import com.example.demo.payment.Payment;

import java.util.LinkedList;

public class Order {
    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;

    void setPaymentStrategy(Payment payment){
        NavigatePayment navigate = new NavigatePayment();
        navigate.setPaymentMethod(payment);
    };

    void setDeliveryStrategy(Delivery delivery){
        NavigateDelivery navigate = new NavigateDelivery();
        navigate.setDeliveryMethod(delivery);
    }

    public int calculateTotalPrice(){
        int sum = 0;
        for (int i = 0; i< items.size(); ++i){
            sum += items.get(i).getPrice();
        }
        return sum;
    }

    public void processOrder(){
        setDeliveryStrategy(delivery);
        setPaymentStrategy(payment);
    }

    void addItem(Item item){
        items.add(item);
    }

    void removeItem(Item item){
        items.remove(item);
    }
}

