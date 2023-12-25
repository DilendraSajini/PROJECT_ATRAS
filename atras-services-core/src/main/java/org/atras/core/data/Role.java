package org.atras.core.data;

import java.util.List;

public class Role {

	private Integer roleId;
	
	private String role;
	
	private List<Permission> permissions;
	
	private List<User> users;

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Integer getRoleId() {
		return roleId;
	}

	public String getRole() {
		return role;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public List<User> getUsers() {
		return users;
	}

	public Role(Integer roleId, String role, List<Permission> permissions, List<User> users) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.permissions = permissions;
		this.users = users;
	}
}
