package com.tomasztokarczyk.exchange.webclient.dto.currency;

import lombok.Getter;

@Getter
public class WebClientCurrencyRatesDto {

    private String effectiveDate;
    private float mid;
}
