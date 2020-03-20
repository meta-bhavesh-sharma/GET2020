package com.metacube.training.model.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class LoginCommands {

	@NotNull
	@NotBlank(message = "Field Empty")
	String email;

	@NotNull
	@NotBlank(message = "Field Empty")
	String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
