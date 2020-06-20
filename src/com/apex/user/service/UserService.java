package com.apex.user.service;

import com.apex.user.dao.UserDAO;
import com.apex.user.vo.UserVODB;
import com.apex.user.vo.UserVO;

public class UserService {

	public void addUser(UserVO userVO) {
		UserDAO userDAO = new UserDAO();

		try {
			userDAO.addUser(this.convertVOUserTODBUser(userVO));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public UserVO getUser(int id) {
		UserDAO userDAO = new UserDAO();
		UserVO userVO = this.convertDBUserTOVOUser(userDAO.getUser(id));

		System.out.println(" USER VO " + userVO.getLastName());
		System.out.println("UserService.getUser():EndfromService()");

		return userVO;

	}

	public void updateUser(UserVO userVO) {
		UserDAO userDAO = new UserDAO();

		userDAO.updateUser(this.convertVOUserTODBUser(userVO));

	}

	public void deleteUser(int id) {
		UserDAO userDAO = new UserDAO();
		UserVO userVO=new UserVO();
		userVO.setUserId(id);
		userDAO.deleteUser(this.convertVOUserTODBUser(userVO));
		
	}

	private UserVO convertDBUserTOVOUser(UserVODB userVODB) {
		UserVO userVO = new UserVO();
		userVO.setUserId(userVODB.getUserId());
		userVO.setFirstName(userVODB.getFirstName());
		userVO.setMiddleName(userVODB.getMiddleName());
		userVO.setLastName(userVODB.getLastName());
		return userVO;

	}

	private UserVODB convertVOUserTODBUser(UserVO userVO) {
		UserVODB userVODB = new UserVODB();
		userVODB.setUserId(userVO.getUserId());
		userVODB.setFirstName(userVO.getFirstName());
		userVODB.setMiddleName(userVO.getMiddleName());
		userVODB.setLastName(userVO.getLastName());
		return userVODB;

	}
}
