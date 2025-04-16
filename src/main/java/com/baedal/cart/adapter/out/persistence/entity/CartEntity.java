package com.baedal.cart.adapter.out.persistence.entity;



import jakarta.persistence.*;

import java.util.List;

@Entity
public class CartEntity {

    @Id
    private long foodId;  // PK로 사용할 foodId

    private String foodName;
    private int foodPrice;
    private int amount;

    @ElementCollection
    @CollectionTable(name = "cart_option", joinColumns = @javax.persistence.JoinColumn(name = "food_id"))
    @Column(name = "option_name")
    private List<String> optionName;  // 옵션 이름

    @ElementCollection
    @CollectionTable(name = "cart_option_price", joinColumns = @javax.persistence.JoinColumn(name = "food_id"))
    @Column(name = "option_price")
    private List<Integer> optionPrice;  // 옵션 가격

    @ElementCollection
    @CollectionTable(name = "cart_option_id", joinColumns = @javax.persistence.JoinColumn(name = "food_id"))
    @Column(name = "option_id")
    private List<Long> optionId;  // 옵션 ID



}