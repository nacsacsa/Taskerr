package com.Tasker.Tasker.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tasker.Tasker.data.entity.taskEntity;

@Repository
public interface taskRepository extends JpaRepository<taskEntity, Long> {
	taskEntity findById(String id);
	List<taskEntity> findAllBytask_done(boolean x);
	List<taskEntity> findAllByTable_id(String id);
	
}