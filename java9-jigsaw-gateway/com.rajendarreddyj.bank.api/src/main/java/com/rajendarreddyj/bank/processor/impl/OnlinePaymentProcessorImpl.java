package com.rajendarreddyj.bank.processor.impl;

import com.rajendarreddyj.bank.api.PaymentProcessor;
import com.rajendarreddyj.bank.enums.CardType;
import com.rajendarreddyj.bank.processor.card.CardProcessor;
import com.rajendarreddyj.bank.processor.card.impl.AmexCardPaymentProcessorImpl;
import com.rajendarreddyj.bank.processor.card.impl.MasterCardPaymentProcessorImpl;
import com.rajendarreddyj.bank.processor.card.impl.VISACardPaymentProcessorImpl;
import com.rajendarreddyj.bank.request.PaymentRequest;
import com.rajendarreddyj.bank.response.CustomerResponse;

/**
 * @author rajendarreddy.jagapathi
 */
public class OnlinePaymentProcessorImpl implements PaymentProcessor {
    private final CardProcessor visaCardPaymentProcessor = new VISACardPaymentProcessorImpl();
    private final CardProcessor masterCardPaymentProcessor = new MasterCardPaymentProcessorImpl();
    private final CardProcessor amexCardPaymentProcessor = new AmexCardPaymentProcessorImpl();

    /* (non-Javadoc)
     * @see com.rajendarreddyj.bank.api.PaymentProcessor#processPayment(java.lang.String, java.lang.String, java.lang.String, java.lang.String, double)
     */
    @Override
    public CustomerResponse processPayment(final String cardNumber, final String cardType, final String expDate, final String cvv, final double amount) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCardNumber(cardNumber);
        paymentRequest.setCardType(CardType.getCardType(cardType));
        paymentRequest.setAmount(amount);

        CustomerResponse customerResponse = new CustomerResponse();
        if (CardType.VISA.equals(paymentRequest.getCardType())) {
            customerResponse = this.visaCardPaymentProcessor.processPayment(paymentRequest);
        } else if (CardType.MASTER.equals(paymentRequest.getCardType())) {
            customerResponse = this.masterCardPaymentProcessor.processPayment(paymentRequest);
        } else if (CardType.AMEX.equals(paymentRequest.getCardType())) {
            customerResponse = this.amexCardPaymentProcessor.processPayment(paymentRequest);
        }
        return customerResponse;
    }

}
