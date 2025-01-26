package com.smart.commerce.order.module.order.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "delivery_id")
    private Long deliveryId;

    @Column(name = "store_price")
    private Long storePrice;

    @Column(name = "delivery_price")
    private Long deliveryPrice;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "delivery_status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "order_number")
    private UUID orderNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public static OrderEntity create(Long userId, Long storeId, UUID orderNumber) {
        return new OrderEntity(null, userId, storeId, OrderStatus.PENDING_PAYMENT, orderNumber, LocalDateTime.now(), LocalDateTime.now());
    }

}
