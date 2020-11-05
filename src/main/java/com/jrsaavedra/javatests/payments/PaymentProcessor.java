package com.jrsaavedra.javatests.payments;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse response = this.paymentGateway.requestPayment(
                new PaymentRequest(amount)
        );
        if(response.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        }
        return false;
    }
}
