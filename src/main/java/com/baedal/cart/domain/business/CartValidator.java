package com.baedal.cart.domain.business;

import com.baedal.cart.application.command.ValidateOrderInfoCommand;
import com.baedal.cart.domain.model.GetCart;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class CartValidator {

  public void validateOrderInfo(ValidateOrderInfoCommand.Request req, GetCart cart) {

    Set<Long> productIdsRequest = new HashSet<>(req.getProductIds());

    if (
        cart == null ||
        !req.getStoreId().equals(cart.getStoreId()) ||
        !productIdsRequest.equals(cart.getProductId())
    ) {
      throw new RuntimeException("장바구니 정보가 일치하지 않습니다.");
    }
  }
}
