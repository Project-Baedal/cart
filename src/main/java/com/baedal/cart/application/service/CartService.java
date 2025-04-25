package com.baedal.cart.application.service;

import com.baedal.cart.application.command.ValidateOrderInfoCommand;
import com.baedal.cart.application.port.in.CartUseCase;
import com.baedal.cart.application.port.out.MessageSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService implements CartUseCase {

  private final MessageSenderPort messageSenderPort;

  @Override
  public void validateOrderInfo(ValidateOrderInfoCommand.Request req) {

    // 1. 장바구니 조회

    try {
      // 2. 요청 값과 비교

      // 3. 결과 메세지 전송
      messageSenderPort.sendSuccessOrderValidate(req.getOrderTransactionId());
    } catch (Exception e) {
      messageSenderPort.sendFailOrderValidate(req.getOrderTransactionId(), e.getMessage());
    }

  }
}
