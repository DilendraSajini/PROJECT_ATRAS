package proxy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import persistence.PermissionDBRepository;
import persistence.exception.RoleNotFoundException;
import persistence.model.PermissionDao;
import ports.out.PermissionRepository;

public class PermissionRepositoryImpl implements PermissionRepository{

	@Autowired
	private PermissionDBRepository permissionDBRepository;
	
	@Override
	public String findPermissions(Integer permissionId) {
		Optional<PermissionDao> permissionDao = permissionDBRepository.findById(permissionId);
		PermissionDao permissionDaoSaved;
		if (permissionDao.isPresent()) {
			permissionDaoSaved = permissionDao.orElse(null);
		} else {
			throw new RoleNotFoundException("Permission not found, for id: " + permissionId);
		}
		return permissionDaoSaved.getPermissionLevel();
	}
	
	
	protected PermissionDao findPermissionsById(Integer permissionId) {
		Optional<PermissionDao> permissionDao = permissionDBRepository.findById(permissionId);
		PermissionDao permissionDaoSaved;
		if (permissionDao.isPresent()) {
			permissionDaoSaved = permissionDao.orElse(null);
		} else {
			throw new RoleNotFoundException("Permission not found, for id: " + permissionId);
		}
		return permissionDaoSaved;
	}
}
