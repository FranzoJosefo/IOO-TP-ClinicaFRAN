package main.java.entity;

import main.java.dto.CredentialsDTO;

public class Credentials {
	private String username;
	private String password;
	
	public Credentials(CredentialsDTO dto) {
		this.username = dto.getUsername();
		this.password = dto.getPassword();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean equals(Object obj) {
		Credentials credential = (Credentials) obj;
		if(credential.getUsername().equals(this.username) && credential.getPassword().equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + "]";
	}
	
	public CredentialsDTO toDTO() {
		return new CredentialsDTO(username, password);
	}
	
}
