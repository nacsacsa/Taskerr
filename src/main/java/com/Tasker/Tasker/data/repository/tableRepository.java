package com.Tasker.Tasker.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tasker.Tasker.data.entity.tableEntity;

@Repository
public interface tableRepository extends JpaRepository<tableEntity, Long> {
	tableEntity findById(String email);
}