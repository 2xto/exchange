package com.tomasztokarczyk.exchange.webclient.dto.currency;

import lombok.Getter;

@Getter
public class WebClientCurrencyDto {

    private String currency;
    private String code;
    private WebClientCurrencyRatesDto[] rates;
}
