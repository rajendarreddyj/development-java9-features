package com.rajendarreddyj.bank.factory;

import com.rajendarreddyj.bank.api.PaymentProcessor;
import com.rajendarreddyj.bank.processor.impl.OnlinePaymentProcessorImpl;

/**
 * @author rajendarreddy.jagapathi
 */
public class BankFactory {
    private BankFactory() {
    }

    public static PaymentProcessor getOnlinePaymentProcessorInstance() {
        return new OnlinePaymentProcessorImpl();
    }

}
