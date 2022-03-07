package com.tomasztokarczyk.exchange.service;

import com.tomasztokarczyk.exchange.model.ExchangeCurrencyDto;
import com.tomasztokarczyk.exchange.model.ExchangeGoldDto;
import com.tomasztokarczyk.exchange.webclient.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final NbpClient nbpClient;

    public ExchangeCurrencyDto getCurrencyExchange(String currencyCode){
        return nbpClient.getCurrencyExchange(currencyCode);
    }

    public ExchangeGoldDto getGoldExchange(){
        return nbpClient.getGoldExchange();
    }



}
