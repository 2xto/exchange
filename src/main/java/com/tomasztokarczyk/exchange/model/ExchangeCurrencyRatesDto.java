package com.tomasztokarczyk.exchange.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeCurrencyRatesDto {

    private String date;
    private float avgRate;
}
