/**
 * 
 */
package com.roy.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author Roy
 *
 */
@Service
public class UserComsumerService {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "userServiceFallback")
	public String nameService() {
		return restTemplate.getForEntity("http://User-SERVICE/user/name?firstName=Roy&lastName=Zeng", String.class).getBody();
	}

	public String userServiceFallback() {
		return "Error: Can't connect to your server.";
	}
}
