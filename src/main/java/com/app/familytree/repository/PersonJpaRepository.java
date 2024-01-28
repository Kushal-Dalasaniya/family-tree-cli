package com.app.familytree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.familytree.entity.Person;

public interface PersonJpaRepository extends JpaRepository<Person, Integer> {
	Person findByName(String name);
}
