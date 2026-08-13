package com.pruebatecnica.brianmh.pyme;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pruebatecnica.brianmh.pyme.entity.Cliente;
import com.pruebatecnica.brianmh.pyme.service.ClienteService;
import com.pruebatecnica.brianmh.pyme.service.ClienteServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
class PymeApplicationTests {

	@Autowired
	private ClienteService clienteService;

	@Test
	void contextLoads() {
	}

	@TestConfiguration
    static class ClienteServiceImplTestContextConfiguration {
 
        @Bean
        public ClienteService clienteService() {
            return new ClienteServiceImpl();
        }
    }


	@Test
	public void whenValidId_thenClienteShouldBeFound() {
		Long id = 1L;
		Cliente found = clienteService.getById(id);
	
		assertThat(found.getId())
		.isEqualTo(id);
	}
}
