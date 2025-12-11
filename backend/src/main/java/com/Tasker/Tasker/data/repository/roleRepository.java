package com.Tasker.Tasker.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tasker.Tasker.data.entity.roleEntity;

@Repository
public interface roleRepository extends JpaRepository<roleEntity,Long> {
	roleEntity findByName(String name);
}