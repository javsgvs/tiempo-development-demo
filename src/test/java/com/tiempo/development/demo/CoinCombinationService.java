package com.tiempo.development.demo;

import com.tiempo.development.demo.models.CoinCombination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinCombinationService {
    @Autowired
    private RestTemplate restTemplate;

    public CoinCombination getCombination(double dollarValue){
        ResponseEntity<CoinCombination> resp = restTemplate.getForEntity("http://localhost:8080/coinRestAPI/getCombination/1" + dollarValue, CoinCombination.class);
        return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
    }
}
