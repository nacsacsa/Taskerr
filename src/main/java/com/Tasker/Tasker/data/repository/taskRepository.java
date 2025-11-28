package com.Tasker.Tasker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tasker.Tasker.data.entity.taskEntity;

@Repository
public interface taskRepository extends JpaRepository<taskEntity, Long> {
	taskEntity findById(String email);
}