package com.springBoot.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.test.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired UserService service;
	
	/**
	 * 获取所有的User
	 * @return
	 */
	@GetMapping("/users")
	public List<User> findAllUser() {
		
		return userRepository.findAll();
	}
	
	/**
	 * 更新User
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}
	/**
	 * 删除User
	 * url: http://localhost:8080/springBoot/test/2/user
	 * @param userId
	 */
	@DeleteMapping("/{id}/user")
	public void updateUser(@PathVariable("id") Integer userId) {
		
		userRepository.delete(userId);
	}
	/**
	 * 增加User
	 * url：http://localhost:8080/springBoot/test/add
	 * @param user
	 * @return
	 */
	@PostMapping("/add")
	public User addUser(User user) {
		
		return userRepository.save(user);
	}
	/**
	 * 自定义方法，通过名字查找User
	 * url:http://localhost:8080/springBoot/test/hello/user
	 * @param username
	 * @return
	 */
	@PostMapping("/{username}/user")
	public List<User> findByUsername(@PathVariable("username") String username) {
		
		return userRepository.findByUsername(username);
	}
	/**
	 * 插入两条数据，配置事物
	 */
	@PostMapping("/addTwoUser")
	public void addTwoUser() {
		
		service.saveUser();
	}

}
