package com.baedal.cart.adapter.in.web.dto;

import lombok.Data;

@Data
public class CartReq {
    private long foodId;
    private String foodName;
    private int foodPrice;
    private int amount;
    private String[] optionName;
    private int[] optionPrice;
    private long[] optionId;
}
