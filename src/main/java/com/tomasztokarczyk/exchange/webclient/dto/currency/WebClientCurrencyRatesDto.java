package com.tomasztokarczyk.exchange.webclient.dto.currency;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WebClientCurrencyRatesDto {

    private String effectiveDate;
    private float mid;
}
