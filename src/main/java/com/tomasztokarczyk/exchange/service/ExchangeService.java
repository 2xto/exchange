package com.tomasztokarczyk.exchange.service;

import com.tomasztokarczyk.exchange.model.ExchangeCurrencyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ExchangeService {

    private RestTemplate restTemplate = new RestTemplate();

    public ExchangeCurrencyDto getCurrencyExchange(final String currencyCode) {
        final String response = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/{currencyCode}/last/1/"
                , String.class, currencyCode);
        log.info(response);
        return null;
    }
}
