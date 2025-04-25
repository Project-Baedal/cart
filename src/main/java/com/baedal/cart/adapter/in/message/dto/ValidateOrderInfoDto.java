package com.baedal.cart.adapter.in.message.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class ValidateOrderInfoDto {

  @Getter
  @Builder
  public static class Request {
    private String orderTransactionId;
    private Long customerId;
    private Long storeId;
    private List<Long> productIds;
  }
}
