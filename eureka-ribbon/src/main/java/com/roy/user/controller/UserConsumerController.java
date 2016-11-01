/**
 * 
 */
package com.roy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roy.user.service.UserComsumerService;

/**
 * @author Roy
 *
 */
@RestController
@RequestMapping(value="/user")
public class UserConsumerController {
	@Autowired
	UserComsumerService userComsumerService;
   
	@RequestMapping(value = "/name", method = RequestMethod.GET)
    public String name() {
        return userComsumerService.nameService();
    }

}
