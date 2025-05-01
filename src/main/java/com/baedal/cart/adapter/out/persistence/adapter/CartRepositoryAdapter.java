package com.baedal.cart.adapter.out.persistence.adapter;

import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import com.baedal.cart.adapter.out.persistence.manager.CartReader;
import com.baedal.cart.adapter.out.persistence.mapper.CartPersistenceMapper;
import com.baedal.cart.application.port.out.CartRepositoryPort;
import com.baedal.cart.domain.model.GetCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartRepositoryAdapter implements CartRepositoryPort {

  private final CartReader cartReader;
  private final CartPersistenceMapper cartMapper;

  @Override
  public GetCart getCartByCustomerId(Long customerId) {
    CartEntity cart = cartReader.findByCustomerId(customerId);
    return cartMapper.entityToDomain(cart);
  }
}
