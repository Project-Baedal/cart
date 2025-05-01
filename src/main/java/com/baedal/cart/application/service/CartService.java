package com.baedal.cart.application.service;

import com.baedal.cart.application.command.ValidateOrderInfoCommand;
import com.baedal.cart.application.port.in.CartUseCase;
import com.baedal.cart.application.port.out.CartRepositoryPort;
import com.baedal.cart.application.port.out.MessageSenderPort;
import com.baedal.cart.domain.business.CartValidator;
import com.baedal.cart.domain.model.GetCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService implements CartUseCase {

  private final MessageSenderPort messageSenderPort;
  private final CartRepositoryPort cartRepositoryPort;
  private final CartValidator cartValidator;

  @Override
  public void validateOrderInfo(ValidateOrderInfoCommand.Request req) {

    try {
      // 1. 장바구니 조회
      GetCart cart = cartRepositoryPort.getCartByCustomerId(req.getCustomerId());
      // 2. 요청 값과 비교
      cartValidator.validateOrderInfo(req, cart);
      // 3. 결과 메세지 전송
      messageSenderPort.sendSuccessOrderValidate(req.getOrderTransactionId());
    } catch (Exception e) {
      messageSenderPort.sendFailOrderValidate(req.getOrderTransactionId(), e.getMessage());
    }

  }
}
