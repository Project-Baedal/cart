package com.baedal.cart.adapter.out.persistence.entity;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carts")
@Getter
public class CartEntity {

  @Id
  private ObjectId id;

  private Long customerId;

  private Long storeId;

  private Set<Long> productId;

  @Builder
  public CartEntity(Long customerId, Long storeId, Set<Long> productId) {
    this.customerId = customerId;
    this.storeId = storeId;
    this.productId = productId;
  }
}
