package de.jgsoftware.lanserver.model;

import javax.persistence.*;
import de.jgsoftware.lanserver.model.interfaces.iMUsers;
@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "DEMODB")
public class Users implements iMUsers
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	private String username;

	private String password;
	private String role;


	/*
	public User(String username, String password, String role)
	{
		this.username = username;
		this.password = password;
		this.role = role;
	}
		*/
	@Override
	public long getId() {
		return id;
	}
	@Override
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getRole() {
		return role;
	}
	@Override
	public void setRole(String role) {
		this.role = role;
	}
}
