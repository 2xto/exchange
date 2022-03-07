package com.tomasztokarczyk.exchange.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExchangeCurrencyDto {

    private String currency;
    private String currencyCode;
    private ExchangeCurrencyRatesDto[] averageRates;
}
