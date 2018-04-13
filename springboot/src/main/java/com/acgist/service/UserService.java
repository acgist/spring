package com.acgist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acgist.aop.TimePoint;
import com.acgist.dao.UserRepository;
import com.acgist.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private EhCacheCacheManager cacheManager;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Transactional(readOnly = false)
	@TimePoint(name = "添加用户", time = 0)
	public UserEntity create(String name) {
		UserEntity user = new UserEntity();
		user.setAge(10);
		user.setName(name);
		userRepository.save(user);
		return user;
	}
	
	@Transactional(readOnly = true)
	@Cacheable(value = "user", key = "#name")
	public UserEntity findOne(String name) {
		return userRepository.findOne(name);
	}
	
	@CacheEvict(value = "user", key = "#name")
	public void remove(String name) {
		System.out.println(cacheManager.getCacheManager().getCache("user").getKeys());
	}
	
	@Transactional(readOnly = true)
	public Page<UserEntity> findPage(Integer page) {
		PageRequest pageable = PageRequest.of(page == null ? 1 : page, 10, Sort.by(Sort.Order.desc("id")));
		return userRepository.findAll(pageable);
	}
	
}
