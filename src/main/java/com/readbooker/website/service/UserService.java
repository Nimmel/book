package com.readbooker.website.service;

import com.readbooker.website.model.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * User 服务接口.
 * 
 * @since 1.0.0 2017年3月18日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface UserService {
	/**
	 * 保存用户
	 * @param user 用户
	 * @return user
	 */
	User saveUser(User user);
	
	/**
	 * 删除用户
	 * @param id 用户id
	 * @return void
	 */
	void removeUser(Long id);
	
	/**
	 * 删除列表里面的用户
	 * @param users 批量删除用户
	 * @return
	 */
	void removeUsersInBatch(List<User> users);
	
	/**
	 * 更新用户
	 * @param user 用户
	 * @return
	 */
	User updateUser(User user);
	
	/**
	 * 根据id获取用户
	 * @param id 用户id
	 * @return
	 */
	User getUserById(Long id);
	
	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> listUsers();
	
	/**
	 * 根据用户名进行分页模糊查询
	 * @param name
	 * @return
	 */
	Page<User> listUsersByUsernameLike(String name, Pageable pageable);

	boolean checkUserExist(String username);

	boolean checkUserPassword(String username,String password);

}
