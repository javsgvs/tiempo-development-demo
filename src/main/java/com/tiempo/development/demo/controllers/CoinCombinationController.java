package com.tiempo.development.demo.controllers;

import com.tiempo.development.demo.models.CoinCombination;
import com.tiempo.development.demo.services.ICoinCombinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coinRestAPI")
@CrossOrigin("*")
public class CoinCombinationController {

    @Autowired
    private ICoinCombinationService coinCombinationService;

    @GetMapping( path = "getCombination/{dollarValue}")
    public CoinCombination getCombination(@PathVariable("dollarValue") Double dollarValue) {
        return coinCombinationService.getCombination(dollarValue);
    }
}
