package com.tomasztokarczyk.exchange.controller;

import com.tomasztokarczyk.exchange.model.ExchangeCurrencyDto;
import com.tomasztokarczyk.exchange.model.ExchangeGoldDto;
import com.tomasztokarczyk.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/api/exchange-rates/{currencyCode}")
    public ExchangeCurrencyDto getCurrencyExchange(@PathVariable String currencyCode) {
        return exchangeService.getCurrencyExchange(currencyCode);
    }

    @GetMapping("/api/gold-price/average")
    public ExchangeGoldDto getGoldExchange() {
        return exchangeService.getGoldExchange();
    }
}
