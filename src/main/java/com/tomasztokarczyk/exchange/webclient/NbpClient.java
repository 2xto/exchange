package com.tomasztokarczyk.exchange.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tomasztokarczyk.exchange.model.ExchangeCurrencyDto;
import com.tomasztokarczyk.exchange.model.ExchangeGoldDto;
import com.tomasztokarczyk.exchange.webclient.dto.currency.WebClientCurrencyDto;
import com.tomasztokarczyk.exchange.webclient.dto.gold.WebClientGoldDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class NbpClient {

    public static final String NBP_URL = "http://api.nbp.pl/api/";
    private RestTemplate restTemplate = new RestTemplate();
    final ObjectMapper mapper = new ObjectMapper();
    final Gson gson = new Gson();

    public ExchangeGoldDto getGoldExchange() {
        String response = restTemplate.getForObject(NBP_URL + "cenyzlota/last/14/?format=json", String.class);
        WebClientGoldDto[] goldArray = gson.fromJson(response, WebClientGoldDto[].class);
        List<WebClientGoldDto> goldList = Arrays.asList(goldArray);

        return ExchangeGoldDto.builder()
                .averageGoldPrice(5)
                .build();
    }

    public ExchangeCurrencyDto getCurrencyExchange(final String currencyCode) {
        String response = restTemplate.getForObject(NBP_URL + "exchangerates/rates/a/{currencyCode}/last/5/?format=json", String.class, currencyCode);
        WebClientCurrencyDto webClientCurrencyDtos = gson.fromJson(response, WebClientCurrencyDto.class);
        return ExchangeCurrencyDto.builder()
                .currency(webClientCurrencyDtos.getCurrency())
                .currencyCode(webClientCurrencyDtos.getCode())
                .build();
    }
}