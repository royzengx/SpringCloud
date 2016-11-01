/**
 * 
 */
package com.roy.user.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Roy
 *
 */
@FeignClient(value = "user-service", fallback = UserClientHystrix.class)
public interface UserClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/name" )
    String name(
    		@RequestParam(value = "firstName") String firstName, 
    		@RequestParam(value = "lastName") String lastName);

}
