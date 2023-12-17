package proxy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import persistence.RoleDBRepository;
import persistence.exception.RoleNotFoundException;
import persistence.mapper.RoleDaoMapper;
import persistence.model.PermissionDao;
import persistence.model.RoleDao;
import data.Role;
import ports.out.RoleRepository;

public class RoleRepositoryImpl implements RoleRepository {

	@Autowired
	private RoleDBRepository roleRepository;

	private PermissionRepositoryImpl permissionRepository;

	public RoleRepositoryImpl(PermissionRepositoryImpl permissionRepository) {
		this.permissionRepository = permissionRepository;
	}

	@Override
	@Transactional
	public List<String> findRoles() {
		List<RoleDao> listOfRoles = roleRepository.findAll();
		List<String> rolesList = listOfRoles.stream().map(roleDao -> RoleDaoMapper.mapRoleDaotoRole(roleDao))
				.collect(Collectors.toList());
		return rolesList;
	}

	@Override
	@Transactional
	public String findRolesById(Integer roleId) {
		Optional<RoleDao> roleDao = roleRepository.findById(roleId);
		String role;
		if (roleDao.isPresent()) {
			RoleDao roleDaoSaved = roleDao.orElse(null);
			role = RoleDaoMapper.mapRoleDaotoRole(roleDaoSaved);
		} else {
			throw new RoleNotFoundException("Role not found, for user id " + roleId);
		}

		return role;
	}

	@Transactional
	protected RoleDao findRolesByRole(String roleName) {
		Optional<RoleDao> roleDao = roleRepository.getByRole(roleName);
		RoleDao roleDaoSaved;
		String role;
		if (roleDao.isPresent()) {
			roleDaoSaved = roleDao.orElse(null);
		} else {
			throw new RoleNotFoundException("Role not found, for role name:" + roleName);
		}
		return roleDaoSaved;
	}

	@Override
	@Transactional
	public Role saveRole(Role role) {
		List<PermissionDao> permissionDaoList = role.getPermissions().stream()
				.map(permisstion -> permissionRepository.findPermissionsById(permisstion.getPermissionId()))
				.collect(Collectors.toList());
		RoleDao newRoleDao = RoleDaoMapper.mapRoletoRoleDao(role, permissionDaoList);
		roleRepository.save(newRoleDao);
		role.setRoleId(newRoleDao.getRoleId());
		return role;
	}
}
