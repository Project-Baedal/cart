package com.baedal.cart.adapter.out.persistence.mapper;

import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import com.baedal.cart.domain.model.GetCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartPersistenceMapper {

  GetCart entityToDomain(CartEntity cartEntity);

}
