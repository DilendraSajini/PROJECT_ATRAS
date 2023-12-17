package persistence.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "ROLE")
public class RoleDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;

	@Size(min = 2, message = "Role should have atleast 2 characters")
	@Column(unique = true)
	private String role;

	@ManyToMany
	    @JoinTable(
	        name = "ROLE_PERMISSION",
	        joinColumns = @JoinColumn (name = "roleId"),
	        inverseJoinColumns = @JoinColumn(name = "permissionId")
	    )
	private List<PermissionDao> permissions;

	@ManyToMany(mappedBy = "role", cascade = CascadeType.ALL) // mappedBy refers to the field in UserDao
	private List<UserDao> users; // lazy fetching not work

	public RoleDao() {

	}

	private RoleDao(RoleDaoBuilder roleDaoBuilder) {
		this.role = roleDaoBuilder.role;
		this.permissions = roleDaoBuilder.permissions;
	}

	public String getRole() {
		return role;
	}

	public List<PermissionDao> getPermissions() {
		return permissions;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public static class RoleDaoBuilder {

		private String role;

		private List<PermissionDao> permissions;

		public RoleDaoBuilder setRole(String role) {
			this.role = role;
			return this;
		}

		public RoleDaoBuilder setRole(String role, List<PermissionDao> permissions) {
			this.role = role;
			this.permissions = permissions;
			return this;
		}

		public RoleDaoBuilder setPermissions(List<PermissionDao> permissions) {
			this.permissions = permissions;
			return this;
		}

		public RoleDao build() {
			return new RoleDao(this);
		}
	}
}
