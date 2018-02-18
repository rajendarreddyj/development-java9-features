package com.rajendarreddyj.payment.gateway.factory;

import com.rajendarreddyj.payment.gateway.api.GatewayProcessor;
import com.rajendarreddyj.payment.processor.impl.PaymentGatewayProcessorImpl;

/**
 * @author rajendarreddy.jagapathi
 */
public class PaymentGatewayFactory {
    private PaymentGatewayFactory() {
    }

    public static GatewayProcessor getGatewayProcessorInstance() {
        return new PaymentGatewayProcessorImpl();
    }
}
