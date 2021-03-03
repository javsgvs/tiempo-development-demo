package com.tiempo.development.demo.services;

import com.tiempo.development.demo.models.CoinCombination;

public interface ICoinCombinationService {

    CoinCombination getCombination(Double dollarValue);
    
}
