package br.com.mbs.microserviceconsumer;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyService {

	
	 private final RestTemplate restTemplate;

	  public MyService(RestTemplate rest) {
	  this.restTemplate = rest;
	  }

	  @HystrixCommand(fallbackMethod = "error")
	  public String meuNome() {
	  URI uri = URI.create("http://localhost:8080/meuNome");

	  return this.restTemplate.getForObject(uri, String.class);
	  }

	  public String error() {
	  return "Ocorreu um erro na busca do nome";
	  }
	
}
