package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderStatus;
import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AbstractAggregateRoot<Order> {

    Long id;

    OrderStatus orderStatus;

    UUID orderNumber;


    public OrderToPaymentEvent pay(ApplicationEventPublisher eventPublisher) {
        OrderToPaymentEvent event = new OrderToPaymentEvent(id, OrderStatus.PENDING_PAYMENT, orderNumber);
        registerEvent(event);
//        eventPublisher.publishEvent(event);
        return event;
    }
}
