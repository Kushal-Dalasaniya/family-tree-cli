package com.app.familytree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.familytree.entity.Person;
import com.app.familytree.entity.Relation;

public interface RelationJpaRepository extends JpaRepository<Relation,Integer> {
	List<Relation> findByMainPersonAndRelationType(Person person,String relation);
	List<Relation> findBySecondPersonAndRelationType(Person person,String relation);
}
