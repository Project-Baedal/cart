package com.baedal.cart.application.port.in;

import com.baedal.cart.application.command.ValidateOrderInfoCommand;

public interface CartUseCase {

  void validateOrderInfo(ValidateOrderInfoCommand.Request req);

}
