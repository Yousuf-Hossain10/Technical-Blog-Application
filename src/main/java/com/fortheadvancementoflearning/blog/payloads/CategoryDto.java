package com.fortheadvancementoflearning.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotEmpty
	@Size(min = 4, message = "The title must be atleast 4 characters long")
	private String categorytitle;
	@NotEmpty
	@Size(min = 10, message = "The description must be atleast 10 characters long")
	private String categoryDescription;
}
