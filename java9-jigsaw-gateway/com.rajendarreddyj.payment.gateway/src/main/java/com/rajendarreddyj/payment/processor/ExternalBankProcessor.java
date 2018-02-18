package com.rajendarreddyj.payment.processor;

import com.rajendarreddyj.bank.api.PaymentProcessor;
import com.rajendarreddyj.bank.factory.BankFactory;
import com.rajendarreddyj.bank.response.CustomerResponse;

/**
 * @author rajendarreddy.jagapathi
 */
public class ExternalBankProcessor {
    private final PaymentProcessor paymentProcessor = BankFactory.getOnlinePaymentProcessorInstance();

    public CustomerResponse processPaymentWithExternalBank(final String cardNumber, final String cardType, final String expDate, final String cvv,
            final double amount) {
        System.out.println("Processing payment with external bank");
        return this.paymentProcessor.processPayment(cardNumber, cardType, expDate, cvv, amount);
    }
}
