package com.readbooker.website.service.impl;

import com.readbooker.website.model.entity.User;
import com.readbooker.website.repository.UserRepository;
import com.readbooker.website.service.UserService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * User 服务.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void removeUsersInBatch(List<User> users) {
		userRepository.deleteInBatch(users);
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> listUsersByUsernameLike(String name, Pageable pageable) {
		// 模糊查询
		name = "%" + name + "%";
		Page<User> users = userRepository.findByUsernameLike(name, pageable);
		return users;
	}

	@Override
	public boolean checkUserExist(String username){
		User user = userRepository.findByUsername(username);
		return user!=null;
	}

	@Override
	public boolean checkUserPassword(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (null==user) {
			return false;
		}
		return user.getPassWord().equals(password);
	}

}
