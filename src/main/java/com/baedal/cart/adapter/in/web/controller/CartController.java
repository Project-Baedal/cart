package com.baedal.cart.adapter.in.web.controller;


import com.baedal.cart.adapter.in.web.dto.CartDto;
import com.baedal.cart.adapter.in.web.dto.CartReq;
import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import com.baedal.cart.adapter.out.persistence.mapper.CartMapper;
import com.baedal.cart.application.command.CartCommand;
import com.baedal.cart.application.port.in.CartUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartUseCase cartUseCase;

    @PostMapping
    public ResponseEntity<Void> addToCart(@RequestBody CartReq cartRequestDto) {
        // Request DTO를 Command로 변환
        CartCommand cartCommand = CartMapper.INSTANCE.toCommand(cartRequestDto);

        // 유즈케이스로 전달
        cartUseCase.addToCart(cartCommand);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<CartEntity> getCart(@PathVariable long foodId) {
        CartEntity cartEntity = cartUseCase.getCart(foodId);
        return ResponseEntity.ok(cartEntity);
    }
}