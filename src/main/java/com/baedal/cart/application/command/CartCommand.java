package com.baedal.cart.application.command;

import lombok.Data;

@Data
public class CartCommand {
    private long foodId;
    private String foodName;
    private int foodPrice;
    private int amount;
    private String[] optionName;
    private int[] optionPrice;
    private long[] optionId;
}
