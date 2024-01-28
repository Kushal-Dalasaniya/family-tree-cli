package com.app.familytree.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "relation",
		uniqueConstraints = {
        @UniqueConstraint(columnNames = {"main_person_id", "second_person_id"})
    })
public class Relation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "main_person_id", nullable = false)
    private Person mainPerson;

    @ManyToOne
    @JoinColumn(name = "second_person_id", nullable = false)
    private Person secondPerson;

    @Column(name="relation_type",nullable = false)
    private String relationType;

	public Person getMainPerson() {
		return mainPerson;
	}

	public void setMainPerson(Person mainPerson) {
		this.mainPerson = mainPerson;
	}

	public Person getSecondPerson() {
		return secondPerson;
	}

	public void setSecondPerson(Person secondPerson) {
		this.secondPerson = secondPerson;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
}
