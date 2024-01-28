package com.app.familytree.cli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.familytree.entity.Relation;
import com.app.familytree.service.FamilyTreeService;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "family-tree",
        description = "Command line interface for user management.")
public class FamilyTreeCLI implements Runnable {
	 @Autowired
	 private FamilyTreeService familyTree;

     @Command(name = "add", description = "Add a person to the family tree.")
     void addPerson(@Parameters(index = "0", description = "Name of the person") String name) {
    	 try {
    		 familyTree.addPerson(name);
    	 }catch(Exception e) {
    		 System.out.println("Error!!! while add person");
    		 System.out.println(e.getSuppressed());
    	 }
     }

     @Command(name = "connect", description = "Connect two people in the family tree.")
     void connectPeople(@Parameters(index = "0", description = "Name of the first person") String name1,
             @Option(names = {"as"}, description = "Relationship") String relationship,
             @Option(names= {"of"}, description = "Name of the second person") String name2) {
    	 try {
    		 familyTree.connectPeople(name1, relationship, name2);
    	 }catch(Exception e) {
    		 System.out.println("Error!!! while save data");
    		 System.out.println(e.getSuppressed());
    	 }
     }
     
     @Command(name = "count", description = "Get count of relations")
     void getCountRelation(@Parameters(index = "0", description = "relationship of person") String relationship,
    		 @Option(names= {"of"}, description = "Name of the second person") String name) {
    	 try {
    		 Integer count = familyTree.getRelationCount(relationship,name);
    		 System.out.println(count +" "+ relationship + " of "+name);
    	 }catch(Exception e) {
    		 System.out.println("Error!!! while get data");
    		 System.out.println(e.getSuppressed());
    	 }
     }
     
     @Command(name="get", description="Get all relations")
     void getRelations(@Parameters(index = "0", description = "relationship of person") String relationship,
    		 @Option(names= {"of"}, description = "Name of the second person") String name) {
    	 try {
    		 List<Relation> relations = familyTree.getAllRelation(relationship,name);
    		 relations.forEach(rel->System.out.println(rel.getMainPerson().getName()));
    	 }catch(Exception e) {
    		 System.out.println("Error!!! while get data");
    		 System.out.println(e.getSuppressed());
    	 }
     }

     @Override
     public void run() {
         CommandLine.usage(new FamilyTreeCLI(), System.out);
     }
}
