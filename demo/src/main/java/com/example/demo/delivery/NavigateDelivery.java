package com.example.demo.delivery;

import lombok.Getter;
import java.util.LinkedList;

public class NavigateDelivery {
    @Getter
    private Delivery delivery;

    public void setDeliveryMethod(Delivery delivery){
        this.delivery = delivery;
    }

    public void DeliverWithChosenMethod(LinkedList items){
        delivery.deliver(items);
    }

}
