package vn.iostar.service.impl;

import vn.iostar.controllers.models.UserModel;
import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.service.IUserService;

public class UserService implements IUserService{
	IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUsername(username);
		
	}

	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		UserModel user = this.findByUserName(username);
		if(user !=null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

}
