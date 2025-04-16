package com.baedal.cart.application.port.out;


import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import java.util.Optional;

public interface CartRepositoryPort {
    void save(CartEntity cartEntity);
    Optional<CartEntity> findById(long foodId);
}
