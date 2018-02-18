package com.rajendarreddyj.bank.processor.card;

import com.rajendarreddyj.bank.request.PaymentRequest;
import com.rajendarreddyj.bank.response.CustomerResponse;

/**
 * @author rajendarreddy.jagapathi
 */
public interface CardProcessor {
    CustomerResponse processPayment(PaymentRequest paymentRequest);
}
