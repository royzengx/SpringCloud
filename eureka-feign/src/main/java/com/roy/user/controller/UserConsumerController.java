/**
 * 
 */
package com.roy.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Roy
 *
 */
@RestController
@RequestMapping(value="/user")
public class UserConsumerController {
	private final Logger logger = LoggerFactory.getLogger(UserConsumerController.class);
	
	@Autowired
	UserClient userClient;
	
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String name() {
    	logger.info("Start to access services via AAAAA and BBBBB from UserClient.");
        return userClient.name("AAAAA", "BBBBB");
    }

}
