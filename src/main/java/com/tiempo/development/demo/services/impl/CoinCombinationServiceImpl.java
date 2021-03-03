package com.tiempo.development.demo.services.impl;

import com.tiempo.development.demo.models.CoinCombination;
import com.tiempo.development.demo.services.ICoinCombinationService;

import org.springframework.stereotype.Service;

@Service
public class CoinCombinationServiceImpl implements ICoinCombinationService {

    @Override
    public CoinCombination getCombination(Double dollarValue) {
        CoinCombination coinCombination = new CoinCombination();
        int aux = (int)(Math.ceil(dollarValue*100));
        
        coinCombination.setSilverDollar(Math.round((int)aux/100));
        aux%=100;

        coinCombination.setHalfDollar(Math.round((int)aux/50));
        aux%=50;

        coinCombination.setQuarter(Math.round((int)aux/25));
        aux%=25;

        coinCombination.setDime(Math.round((int)aux/10));
        aux%=10;

        coinCombination.setNickel(Math.round((int)aux/5));
        aux%=5;

        coinCombination.setPenny(Math.round((int)aux/1));

        return coinCombination;
    }
    
}
