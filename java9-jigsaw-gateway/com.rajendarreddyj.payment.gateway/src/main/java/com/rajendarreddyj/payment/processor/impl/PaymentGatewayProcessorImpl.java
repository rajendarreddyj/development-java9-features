package com.rajendarreddyj.payment.processor.impl;

import com.rajendarreddyj.bank.response.CustomerResponse;
import com.rajendarreddyj.payment.gateway.api.GatewayProcessor;
import com.rajendarreddyj.payment.processor.ExternalBankProcessor;

/**
 * @author rajendarreddy.jagapathi
 */
public class PaymentGatewayProcessorImpl implements GatewayProcessor {
    private final ExternalBankProcessor processor = new ExternalBankProcessor();

    @Override
    public CustomerResponse processPayment(final String cardNumber, final String cardType, final String expDate, final String cvv, final double amount) {
        return this.processor.processPaymentWithExternalBank(cardNumber, cardType, expDate, cvv, amount);
    }
}