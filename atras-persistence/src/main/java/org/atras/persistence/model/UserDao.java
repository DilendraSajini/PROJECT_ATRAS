package org.atras.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

//neeed to use single quote in sql table
@Entity
@Table(name = "APP_USER")
public class UserDao{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Size(min = 2, message = "User name should have atleast 2 characters")
	private String username;

	@ManyToOne // FetchType.LAZY is the default, need to add in @JoinColumn side  cascade = { CascadeType.PERSIST, CascadeType.MERGE }
	@JoinColumn(name = "roleId") // This is the foreign key column in USER table
	private RoleDao role;

	public UserDao() {

	}

	public UserDao(String username, RoleDao role) {
		this.username = username;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public RoleDao getRole() {
		return role;
	}

	public Integer getUserId() {
		return userId;
	}

	public static class UserDaoBuilder {

		private String username;
		private RoleDao role;

		public UserDaoBuilder setUserName(String userName) {
			this.username = userName;
			return this;
		}

		public UserDaoBuilder setRole(RoleDao role) {
			this.role = role;
			return this;
		}

		public UserDao build() {
			return new UserDao(username, role);
		}
	}

}
