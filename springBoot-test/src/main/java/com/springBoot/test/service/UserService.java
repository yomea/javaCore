package com.springBoot.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.test.User;
import com.springBoot.test.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void saveUser() {
		
		User user_1 = new User(null, "天龙八部");
		
		userRepository.save(user_1);
		
		User user_2 = new User(null, "神雕侠侣");
		
		userRepository.save(user_2);
	}

}
