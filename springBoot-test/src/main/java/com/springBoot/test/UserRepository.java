package com.springBoot.test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * 添加自定义的查询方法，必须按照这种格式来添加，这样springBoot才会自动生成它的实现。
	 * @return
	 */
	List<User> findByUsername(String username);

}
