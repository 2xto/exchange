package com.tomasztokarczyk.exchange.webclient.dto.gold;

import lombok.Getter;

@Getter
public class WebClientGoldDto {

    private float cena;

    @Override
    public String toString() {

        return String.valueOf(cena);
    }
}
