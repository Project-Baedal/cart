package com.baedal.cart.adapter.in.message.listener;

import com.baedal.cart.adapter.in.message.dto.ValidateOrderInfoDto;
import com.baedal.cart.adapter.in.message.mapper.CartListenerMapper;
import com.baedal.cart.application.command.ValidateOrderInfoCommand;
import com.baedal.cart.application.port.in.CartUseCase;
import com.baedal.cart.util.Converter;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartListener {

  private final Converter converter;
  private final CartListenerMapper cartMapper;
  private final CartUseCase cartUseCase;

  @KafkaListener(topics = "cart.validateCartOrderInfo", groupId = "cart-group")
  public void validateOrderInfo(ConsumerRecord<String, String> record) {
    ValidateOrderInfoDto.Request req = converter.jsonToDto(
        record.value(), ValidateOrderInfoDto.Request.class
    );
    ValidateOrderInfoCommand.Request command = cartMapper.orderValidateToCommand(req);
    cartUseCase.validateOrderInfo(command);
  }

}
