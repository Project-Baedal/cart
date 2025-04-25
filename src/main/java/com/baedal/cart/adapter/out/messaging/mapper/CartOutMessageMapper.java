package com.baedal.cart.adapter.out.messaging.mapper;

import com.baedal.cart.adapter.out.messaging.dto.SendOrderValidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartOutMessageMapper {

  SendOrderValidate orderValidate(boolean status, String message);

}
