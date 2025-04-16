package com.baedal.cart.adapter.out.persistence.mapper;

import com.baedal.cart.adapter.in.web.dto.CartReq;
import com.baedal.cart.application.command.CartCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")  // Spring Bean으로 등록
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    // CartRequestDto -> CartCommand 변환
    CartCommand toCommand(CartReq cartRequestDto);
}