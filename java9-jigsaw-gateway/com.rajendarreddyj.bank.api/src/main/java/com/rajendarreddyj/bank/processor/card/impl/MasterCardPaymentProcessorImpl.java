package com.rajendarreddyj.bank.processor.card.impl;

import com.rajendarreddyj.bank.processor.card.CardProcessor;
import com.rajendarreddyj.bank.request.PaymentRequest;
import com.rajendarreddyj.bank.response.CustomerResponse;

/**
 * @author rajendarreddy.jagapathi
 */
public class MasterCardPaymentProcessorImpl implements CardProcessor {

    /* (non-Javadoc)
     * @see com.rajendarreddyj.bank.api.PaymentProcessor#processPayment(com.rajendarreddyj.bank.api.request.PaymentRequest)
     */
    @Override
    public CustomerResponse processPayment(final PaymentRequest paymentRequest) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setFname("fname");
        customerResponse.setLname("lname");
        customerResponse.setCardType(paymentRequest.getCardType());
        customerResponse.setAmount(paymentRequest.getAmount());
        customerResponse.setTransactionStatus(false);
        return customerResponse;
    }

}
