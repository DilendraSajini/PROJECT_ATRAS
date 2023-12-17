package persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSION")
public class PermissionDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer permissionId;

	private String permissionLevel;

	@ManyToMany(mappedBy = "permissions")
	private List<RoleDao> roles;

	public PermissionDao() {

	}

	public PermissionDao(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public String getPermissionLevel() {
		return permissionLevel;
	}

	public static class PermissionDaoBuilder {
		private String permissionLevel;

		public PermissionDaoBuilder setPermissionLevel(String permissionLevel) {
			this.permissionLevel = permissionLevel;
			return this;
		}

		public PermissionDao build() {
			return new PermissionDao(permissionLevel);
		}
	}

}
