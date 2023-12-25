package org.atras.persistence.proxy.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.atras.core.data.User;
import org.atras.persistence.repository.UserDBRepository;
import org.atras.persistence.exception.UserNotFoundException;
import org.atras.persistence.mapper.UserDaoMapper;
import org.atras.persistence.model.RoleDao;
import org.atras.persistence.model.UserDao;
import org.atras.roles.ports.out.RoleRepository;
import org.atras.users.ports.out.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

// is a proxy and decorator
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private UserDBRepository userRepository;

	@Autowired
	private RoleRepositoryImpl roleRepository;

	@Override
	public User findUsersById(Integer userId) {
		Optional<UserDao> user = userRepository.findById(userId);
		UserDao userDaoSaved;
		if (user.isPresent()) {
			userDaoSaved = user.orElse(null);
		} else {
			throw new UserNotFoundException("User not found, for user id " + userId);
		}
		return UserDaoMapper.mapUserDaotoUser(userDaoSaved);
	}

	@Override
    // @Transactional(propagation = Propagation.REQUIRED)
	public List<User> findUsers() {
		List<UserDao> listOfusers = userRepository.findAll();
		List<User> usersList = listOfusers.stream().map(userDao -> UserDaoMapper.mapUserDaotoUser(userDao))
				.collect(Collectors.toList());
		return usersList;
	}

	@Override
	@Transactional 
	public User saveUser(User user) {
		RoleDao roleDao = roleRepository.findRolesByRole(user.getRole());
		UserDao newUserDao;
		newUserDao = UserDaoMapper.mapUsertoUserDao(user, roleDao);
		userRepository.save(newUserDao);
		return user;
	}

	@Override
	@Transactional // move to service level
	public User deleteUserById(Integer userId) {
		User deteteuser = findUsersById(userId);
		userRepository.deleteById(userId);
		return deteteuser;

	}

}
