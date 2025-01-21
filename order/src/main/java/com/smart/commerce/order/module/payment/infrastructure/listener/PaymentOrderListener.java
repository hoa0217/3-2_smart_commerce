package com.smart.commerce.order.module.payment.infrastructure.listener;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentOrderListener {

    @ApplicationModuleListener
    public void handleOrderEvent(OrderToPaymentEvent event) {
        log.info("{}", event.orderNumber());
    }
}
