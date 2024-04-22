package com.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	// DTO creation is better as we don't expose entity directly to the user
	private int id;
	@NotEmpty
	@Size(min = 4, message = "Username must be at least 4 characters long")
	private String name;
	@Email(message = "Invalid email address")
	@Pattern(regexp = ".+@.+\\..+", message = "Invalid email address")
	private String email;
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be between 3 and 10 characters long")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{3,10}$", message = "Password must be alphanumeric with special characters") //currently this is not thrown, dedicated exception handling req
	private String password;
	@NotEmpty
	private String about;
}