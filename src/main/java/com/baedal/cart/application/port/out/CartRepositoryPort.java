package com.baedal.cart.application.port.out;

import com.baedal.cart.domain.model.GetCart;

public interface CartRepositoryPort {

  GetCart getCartByCustomerId(Long id);
}
