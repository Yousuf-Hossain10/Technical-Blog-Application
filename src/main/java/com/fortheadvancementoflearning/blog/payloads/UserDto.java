package com.fortheadvancementoflearning.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min = 4, message = "The name field must be atleast 4 characters long" )
	private String name;
	
	@Email(message = "The email address is not valid")
	@NotEmpty
	private String email;
	
	@NotNull
	@Size(min = 4, max =10, message = "Password must be minimum of 3 characters and maximum of 10")
	private String password;
	
	@NotNull
	private String about;
}
