package com.baedal.cart.adapter.out.messaging.adapter;

import com.baedal.cart.adapter.out.messaging.dto.SendOrderValidate;
import com.baedal.cart.adapter.out.messaging.mapper.CartOutMessageMapper;
import com.baedal.cart.adapter.out.messaging.sender.KafkaSender;
import com.baedal.cart.application.port.out.MessageSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// note. 이후 Topic 은 SecretKey 로 관리, Key/Value 는 암호화 고려해보면 좋을 것같습니다.
@Component
@RequiredArgsConstructor
public class MessageSenderAdapter implements MessageSenderPort {

  private final KafkaSender kafkaSender;
  private final CartOutMessageMapper storeMapper;

  @Override
  public void sendSuccessOrderValidate(String orderTransactionId) {
    SendOrderValidate req = storeMapper.orderValidate(true, "success");
    kafkaSender.sendMessage("order.orderValidate", orderTransactionId, req);
  }

  @Override
  public void sendFailOrderValidate(String orderTransactionId, String message) {
    SendOrderValidate req = storeMapper.orderValidate(false, message);
    kafkaSender.sendMessage("order.orderValidate", orderTransactionId, req);
  }
}
