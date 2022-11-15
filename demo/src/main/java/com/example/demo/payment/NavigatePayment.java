package com.example.demo.payment;
import lombok.Getter;

public class NavigatePayment {
    @Getter
    private Payment payment;

    public void setPaymentMethod(Payment payment){
        this.payment = payment;
    }

    public void PayWithChosenMethod(double price){
        payment.pay(price);
    }

}
