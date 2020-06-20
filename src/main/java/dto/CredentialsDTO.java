package main.java.dto;

import main.java.Interface.IDto;

public class CredentialsDTO implements IDto {
	
	private String username;
	private String password;
	
	public CredentialsDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
