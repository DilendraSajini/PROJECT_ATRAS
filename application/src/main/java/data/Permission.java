package data;


public class Permission {
	private Integer permissionId;
	
	private String permissionLevel;

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public Permission() {
	}
	
	public Permission(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

}
