/**
 * 
 */
package com.roy.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roy.user.domain.User;

/**
 * @author Roy
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public User createName(
			@RequestParam String firstName, 
			@RequestParam String lastName) {
		ServiceInstance instance = client.getLocalServiceInstance();
		String name = firstName + " " + lastName;
		User user = new User();
		user.setName(name);
		logger.info("/user/name, "
				+ "host:" + instance.getHost() 
				+ ":" + instance.getPort() 
				+ ", service_id:" + instance.getServiceId() 
				+ ", result:" + name);
		return user;
	}

}
