package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.order.infrastructure.repository.entity.DeliveryStatus;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderStatus;
import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;

    private OrderStatus orderStatus;

    private Long deliveryId;

    private DeliveryStatus deliveryStatus;

    private UUID orderNumber;

    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public OrderToPaymentEvent pay(ApplicationEventPublisher eventPublisher) {
        OrderToPaymentEvent event = new OrderToPaymentEvent(id, OrderStatus.PENDING_PAYMENT, orderNumber);
        eventPublisher.publishEvent(event);
        return event;
    }
}
