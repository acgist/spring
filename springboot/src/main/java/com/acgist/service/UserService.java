package com.acgist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acgist.dao.UserRepository;
import com.acgist.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
//	@Transactional(readOnly = false)
	public UserEntity create(String name) {
		UserEntity user = new UserEntity();
		user.setAge(10);
		user.setName(name);
		userRepository.save(user);
		return user;
	}
	
	@Transactional(readOnly = true)
	public UserEntity findOne(String name) {
		return userRepository.findOne(name);
	}
	
	@Transactional(readOnly = true)
	public Page<UserEntity> findPage(Integer page) {
		PageRequest pageable = PageRequest.of(page == null ? 1 : page, 10, Sort.by(Sort.Order.desc("id")));
		return userRepository.findAll(pageable);
	}
	
}
