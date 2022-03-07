package com.tomasztokarczyk.exchange.webclient.dto.currency;

import lombok.Getter;

import java.util.List;

@Getter
public class WebClientCurrencyDto {
    private String currency;
    private String code;
    private List<WebClientCurrencyRatesDto> rates;
}
