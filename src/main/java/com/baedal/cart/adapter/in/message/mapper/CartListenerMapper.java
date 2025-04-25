package com.baedal.cart.adapter.in.message.mapper;

import com.baedal.cart.adapter.in.message.dto.ValidateOrderInfoDto;
import com.baedal.cart.application.command.ValidateOrderInfoCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartListenerMapper {

  // 주문 검증
  ValidateOrderInfoCommand.Request orderValidateToCommand(ValidateOrderInfoDto.Request request);
}
