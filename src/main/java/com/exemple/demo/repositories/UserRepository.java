package com.exemple.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exemple.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT obj FROM User obj " + "WHERE obj.salary >= :minSalary " + "AND obj.salary <= :maxSalary")
	Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);

	@Query("SELECT obj FROM User obj " + "WHERE LOWER(obj.name) like LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchByName(String name, Pageable pageable);

	/*
	 * usando metodo do próprio framework para encontrar o mesmo passo 
	 * dos dois métodos anteriormente digitado
	 */
	
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
