package org.atras.persistence.mapper;


import org.atras.data.User;
import org.atras.persistence.model.RoleDao;
import org.atras.persistence.model.UserDao;

public class UserDaoMapper {
	
	
	public static UserDao mapUsertoUserDao(User user, RoleDao roleDao) {
		UserDao userDao = new UserDao.UserDaoBuilder().setUserName(user.getUsername()).setRole(roleDao).build();
		return userDao;
	}
	
	public static User mapUserDaotoUser(UserDao userDao) {
		User newUser = new User.UserBuilder().setUsername(userDao.getUsername()).setRole(userDao.getRole().getRole()).setUserId(userDao.getUserId()).build();
		return newUser;
	}
}
