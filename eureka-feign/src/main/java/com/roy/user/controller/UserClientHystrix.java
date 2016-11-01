/**
 * 
 */
package com.roy.user.controller;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Roy
 *
 */
public class UserClientHystrix implements UserClient {
	
	@Override
	public String name(
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		return "";
	}

}
