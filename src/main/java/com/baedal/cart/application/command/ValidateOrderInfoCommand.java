package com.baedal.cart.application.command;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class ValidateOrderInfoCommand {

  @Getter
  @Builder
  public static class Request {
    private String orderTransactionId;
    private Long customerId;
    private Long storeId;
    private List<Long> productIds;
  }
}
