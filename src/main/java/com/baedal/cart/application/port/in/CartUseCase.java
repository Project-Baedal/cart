package com.baedal.cart.application.port.in;

import com.baedal.cart.application.command.CartCommand;
import com.baedal.cart.adapter.out.persistence.entity.CartEntity;

public interface CartUseCase {
    void addToCart(CartCommand cartCommand);
    CartEntity getCart(long foodId);
}
