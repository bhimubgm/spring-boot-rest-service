package com.springboot.rest.example.repository;

/**
 * Repository for USER entity operations
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
