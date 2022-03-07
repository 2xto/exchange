package com.tomasztokarczyk.exchange.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExchangeGoldDto {
    private float averageGoldPrice;
}
