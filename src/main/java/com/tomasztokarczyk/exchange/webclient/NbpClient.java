package com.tomasztokarczyk.exchange.webclient;

import com.google.gson.Gson;
import com.tomasztokarczyk.exchange.model.ExchangeCurrencyDto;
import com.tomasztokarczyk.exchange.model.ExchangeCurrencyRatesDto;
import com.tomasztokarczyk.exchange.model.ExchangeGoldDto;
import com.tomasztokarczyk.exchange.webclient.dto.currency.WebClientCurrencyDto;
import com.tomasztokarczyk.exchange.webclient.dto.currency.WebClientCurrencyRatesDto;
import com.tomasztokarczyk.exchange.webclient.dto.gold.WebClientGoldDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class NbpClient {

    public static final String NBP_URL = "http://api.nbp.pl/api/";
    final Gson gson = new Gson();
    private final RestTemplate restTemplate = new RestTemplate();

    public ExchangeGoldDto getGoldExchange() {
        String response = restTemplate.getForObject(
                NBP_URL + "cenyzlota/last/14/?format=json"
                , String.class);
        WebClientGoldDto[] goldArray = gson.fromJson(response, WebClientGoldDto[].class);
        List<String> arr = Arrays.stream(goldArray).map(WebClientGoldDto::toString).toList();
        return ExchangeGoldDto.builder()
                .averageGoldPrice(getSum(arr) / arr.size())
                .build();
    }

    private Float getSum(List<String> list) {
        Float sum = 0f;
        if (!list.isEmpty() && list.size() > 1) {
            for (String s : list) {
                sum += Float.parseFloat(s);
            }
        }
        return sum;
    }

    public ExchangeCurrencyDto getCurrencyExchange(final String currencyCode) {
        String response = restTemplate.getForObject(
                NBP_URL + "exchangerates/rates/a/{currencyCode}/last/5/?format=json"
                , String.class, currencyCode);
        WebClientCurrencyDto webClientCurrencyDto = gson.fromJson(response, WebClientCurrencyDto.class);
        WebClientCurrencyRatesDto[] webRates = webClientCurrencyDto.getRates();
        ExchangeCurrencyRatesDto[] rates = Arrays.stream(webRates).map(rate -> {
            ExchangeCurrencyRatesDto e = new ExchangeCurrencyRatesDto();
            e.setDate(rate.getEffectiveDate());
            e.setAvgRate(rate.getMid());
            return e;
        }).toArray(ExchangeCurrencyRatesDto[]::new);
        return ExchangeCurrencyDto.builder()
                .currency(webClientCurrencyDto.getCurrency())
                .currencyCode(webClientCurrencyDto.getCode())
                .averageRates(rates)
                .build();
    }
}