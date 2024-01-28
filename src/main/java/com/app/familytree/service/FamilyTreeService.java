package com.app.familytree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.familytree.entity.Person;
import com.app.familytree.entity.Relation;
import com.app.familytree.repository.PersonJpaRepository;
import com.app.familytree.repository.RelationJpaRepository;


@Service
public class FamilyTreeService {
	@Autowired
	PersonJpaRepository personRepo;
	@Autowired
	RelationJpaRepository relationRepo;
	
	public void addPerson(String name) {
    	Person person = new Person();
    	person.setName(name.toLowerCase());
    	personRepo.saveAndFlush(person);
        System.out.println("Person added: " + name);
    }

    public void connectPeople(String name1, String relationship, String name2) {
    	Person person1=getPerson(name1);
        Person person2=getPerson(name2);
        saveRelation(person1,person2,relationship.toLowerCase());
        System.out.println("Connected: " + name1 + " as " + relationship + " of " + name2);
    }
    
    public Integer getRelationCount(String relationship, String name) {
    	return getAllRelation(relationship,name).size();
    }
    
    public List<Relation>  getAllRelation(String relationship, String name) {
    	Person person=personRepo.findByName(name);
    	
    	if(person==null) throw new RuntimeException(name +" is not there");
    	Integer length = relationship.length();
    	String rel =  relationship.charAt(length-1)=='s' ? relationship.substring(0,length-1) : relationship;
    	List<Relation> relations = relationRepo.findBySecondPersonAndRelationType(person,rel);
    	
    	return relations;
    }
 
    
    private Relation saveRelation(Person person1,Person person2,String rel) {
    	Relation relation = new Relation();
    	relation.setMainPerson(person1);
    	relation.setSecondPerson(person2);
    	relation.setRelationType(rel);
    	
    	return relationRepo.saveAndFlush(relation);
    }
    
    private Person getPerson(String name){
    	Person person=personRepo.findByName(name);
        
        if(person==null) {
        	Person per = new Person();
        	per.setName(name);
        	person=personRepo.saveAndFlush(per);
        }
        return person;
    }
}
