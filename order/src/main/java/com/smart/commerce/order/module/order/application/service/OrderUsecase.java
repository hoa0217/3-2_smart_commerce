package com.smart.commerce.order.module.order.application.service;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.application.port.ShoppingCartPort;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderUsecase {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final ShoppingCartPort shoppingCartPort;
    private final OrderRepository orderRepository;


    @Transactional
    public Order orderToPayment(OrderRequest orderRequest) {
        ShoppingCart shoppingCart = shoppingCartPort.getItems(orderRequest.userId());
        Order order = orderRepository.save(shoppingCart, orderRequest);
        order.pay(applicationEventPublisher);
        return order;
    }
}
