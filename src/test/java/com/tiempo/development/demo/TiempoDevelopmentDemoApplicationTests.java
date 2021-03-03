package com.tiempo.development.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tiempo.development.demo.models.CoinCombination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class TiempoDevelopmentDemoApplicationTests {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	private CoinCombinationService coinCombinationService;

	@Test
	void contextLoads() {
		CoinCombination combination = new CoinCombination();
		combination.setSilverDollar(0);
		combination.setHalfDollar(1);
		combination.setQuarter(1);
		combination.setDime(2);
		combination.setNickel(0);
		combination.setPenny(4);
		
		assertEquals(coinCombinationService.getCombination(12), combination);
	}

}

/*
package com.tiempo.development.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tiempo.development.demo.models.CoinCombination;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class TiempoDevelopmentDemoApplicationTests {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private CoinCombinationService coinCombinationService = new CoinCombinationService();

	@Test
	void givenMockingIsDoneByMockito_whenGetCombinationIsCalled_shouldReturnMockedObject() {
		CoinCombination combination = new CoinCombination();
		combination.setSilverDollar(0);
		combination.setHalfDollar(1);
		combination.setQuarter(1);
		combination.setDime(2);
		combination.setNickel(0);
		combination.setPenny(4);

		Mockito
			.when(restTemplate.getForEntity("http://localhost:8080/coinRestAPI/getCombination/0.99", CoinCombination.class))
			.thenReturn(new  ResponseEntity<CoinCombination>(combination, HttpStatus.OK));

		
		CoinCombination coinCombination = coinCombinationService.getCombination(0.99);
		assertEquals(combination,coinCombination);
	}

}
*/
