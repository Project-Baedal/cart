package com.baedal.cart.adapter.out.persistence.repository;

import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartMongoRepository extends MongoRepository<CartEntity, ObjectId> {

  Optional<CartEntity> findByCustomerId(Long customerId);
}
