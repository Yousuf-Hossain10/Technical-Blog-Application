package com.fortheadvancementoflearning.blog.payloads;

import lombok.Data;

@Data
public class JWTAuthResponse {

	private String token;
	
	private UserDto user;
}

