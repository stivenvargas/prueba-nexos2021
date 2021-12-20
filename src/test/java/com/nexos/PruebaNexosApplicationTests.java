package com.nexos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nexos.service.IMercanciaService;

@SpringBootTest
class PruebaNexosApplicationTests {
	
	 @MockBean
	 private IMercanciaService iMercanciaService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getMercanciaTest() {
		
	}

}
