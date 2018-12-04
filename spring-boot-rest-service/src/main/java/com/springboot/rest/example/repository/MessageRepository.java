package com.springboot.rest.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.rest.example.entity.Message;

/**
 * Repository for MESSAGE entity operations
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	@Query("SELECT m FROM Message m WHERE m.user.id = :userId")
	public List<Message> findByUserId(@Param("userId") Long userId, Pageable pageable);
}
