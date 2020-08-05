package br.com.mbs.microserviceconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Main {

	
	@Autowired
	private MyService myService;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}
	
	@RequestMapping("/meuNomeConsumer")
	  public String meuNomeConsumer() {
		return myService.meuNome();
	  }
	
	@Bean
	  public RestTemplate rest(RestTemplateBuilder builder) {
	  return builder.build();
	  }

}
