package com.rdops.microservice.nexusservice.nexusservice.nexusModel;

public class NexusBean {
	
	public String nexusip;
	public String username;
	public String password;
	
	public NexusBean() {}
	
	public NexusBean(String nexusip, String username, String password) {
		super();
		this.nexusip = nexusip;
		this.username = username;
		this.password = password;
	}
	public String getNexusip() {
		return nexusip;
	}
	public void setNexusip(String nexusip) {
		this.nexusip = nexusip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "NexusBean [nexusip=" + nexusip + ", username=" + username + ", password=" + password + "]";
	}
	
}
