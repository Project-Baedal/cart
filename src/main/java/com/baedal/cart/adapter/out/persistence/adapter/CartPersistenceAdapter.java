package com.baedal.cart.adapter.out.persistence.adapter;

import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import com.baedal.cart.adapter.out.persistence.repository.CartJpaRepository;
import com.baedal.cart.application.port.out.CartRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CartPersistenceAdapter implements CartRepositoryPort {

    @Autowired
    private CartJpaRepository cartJpaRepository;

    @Override
    public void save(CartEntity cartEntity) {
        cartJpaRepository.save(cartEntity);
    }

    @Override
    public Optional<CartEntity> findById(long foodId) {
        return cartJpaRepository.findById(foodId);
    }
}
