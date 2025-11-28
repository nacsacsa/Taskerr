package com.Tasker.Tasker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tasker.Tasker.data.entity.usersEntity;

@Repository
public interface usersRepository extends JpaRepository<usersEntity, Long> {
	usersEntity findByEmail(String email);
}