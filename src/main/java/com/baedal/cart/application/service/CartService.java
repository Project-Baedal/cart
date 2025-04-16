package com.baedal.cart.application.service;

import com.baedal.cart.adapter.out.persistence.adapter.CartPersistenceAdapter;
import com.baedal.cart.application.command.CartCommand;
import com.baedal.cart.adapter.out.persistence.repository.CartRepository;
import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import com.baedal.cart.adapter.out.persistence.mapper.CartMapper;

import com.baedal.cart.application.port.in.CartUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartUseCase {

    @Autowired
    private CartPersistenceAdapter cartRepository;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addToCart(CartCommand cartCommand) {
        // Command -> Entity로 변환
        CartEntity cartEntity = cartMapper.toEntity(cartCommand);

        // DB에 저장
        cartRepository.save(cartEntity);
    }

    @Override
    public CartEntity getCart(long foodId) {
        // Redis 또는 DB에서 데이터를 조회
        return cartRepository.findById(foodId).orElse(null);
    }
}
