package vn.iostar.service;

import vn.iostar.controllers.models.UserModel;

public interface IUserService {
	UserModel findByUserName(String username);
	UserModel login(String username, String password);
	
}
