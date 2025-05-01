package com.baedal.cart.adapter.out.persistence.manager;

import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import com.baedal.cart.adapter.out.persistence.repository.CartMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartReader {

  private final CartMongoRepository cartMongoRepository;

  public CartEntity findByCustomerId(Long customerId) {
    return cartMongoRepository.findByCustomerId(customerId)
        .orElse(null);
  }

}
