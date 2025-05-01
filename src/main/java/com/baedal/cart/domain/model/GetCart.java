package com.baedal.cart.domain.model;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCart {


  private Long storeId;

  private Set<Long> productId;

}
