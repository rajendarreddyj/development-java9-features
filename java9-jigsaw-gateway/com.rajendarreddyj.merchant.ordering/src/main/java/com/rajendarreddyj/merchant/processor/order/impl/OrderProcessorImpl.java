package com.rajendarreddyj.merchant.processor.order.impl;

import com.rajendarreddyj.bank.email.notifications.impl.EmailNotificationImpl;
import com.rajendarreddyj.bank.notifications.Notification;
import com.rajendarreddyj.merchant.ordering.Processor;
import com.rajendarreddyj.payment.gateway.api.GatewayProcessor;
import com.rajendarreddyj.payment.gateway.factory.PaymentGatewayFactory;

/**
 * @author rajendarreddy.jagapathi
 */
public class OrderProcessorImpl implements Processor {

    public static void main(final String[] args) {
        Processor orderProcessor = new OrderProcessorImpl();
        orderProcessor.processOrder();
    }

    /* (non-Javadoc)
     * @see com.rajendarreddyj.merchant.ordering.Processor#processOrder()
     */
    @Override
    public void processOrder() {
        GatewayProcessor gatewayProcessor = PaymentGatewayFactory.getGatewayProcessorInstance();
        gatewayProcessor.processPayment("1234 5678 9101 1121", "VISA", "0218", "123", 10.01);
        Notification notification = new EmailNotificationImpl();
        notification.sendNotificaion("Order #123456 processed", "user@user.com");

    }

}
