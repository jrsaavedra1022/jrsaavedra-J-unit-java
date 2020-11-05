package com.jrsaavedra.javatests.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);

}
