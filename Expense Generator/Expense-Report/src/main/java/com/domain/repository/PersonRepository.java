package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	public Person findByEmailId(String emailId);
}
