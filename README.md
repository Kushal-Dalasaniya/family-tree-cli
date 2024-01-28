# Family Tree CLI Application

The Family Tree CLI Application is a command-line interface for managing a family tree. It allows users to add persons, connect two people in the family tree, get counts of relations, and retrieve all relations based on specified criteria.

# Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [Commands](#commands)
- [Examples](#examples)


# Installation

Ensure that you have Java installed on your machine. You can build and run the application using Maven.

```bash
# Clone the repository
git clone https://github.com/Kushal-Dalasaniya/family-tree-cli.git

# Navigate to the project directory
cd family-tree-cli

# Build the application
mvn clean install

# Run the application
java -jar target/family-tree-0.0.1-SNAPSHOT.jar
```

# Usage

The Family Tree CLI Application supports various commands for managing a family tree. To see a list of available commands and options, run the application without any arguments.

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar
```

# Database Setup

Before running the application, make sure to set up the database. You can use the provided AppQuery.sql file to create the necessary tables.

Add db url,password and username in application.proerties file. 

# Commands

### Add

Add a person to the family tree.

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar add <name>
```

### Connect

Connect two people in the family tree.

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar connect <name1> as <relationship> of <name2>
```

### Count

Get the count of relations.

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar count <relationship> of <name>
```

### Get

Get all relations.

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar get <relationship> of <name>
```

# Examples

Add a person named "John":

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar add John
```

Connect John as the parent of Mary:

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar connect John as Parent of Mary
```

Get the count of sons of "John":

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar count sons of John
```

Get all relations where John is the parent:

```
java -jar target/family-tree-0.0.1-SNAPSHOT.jar get Parent of John
```

# Use bat File 

The bat batch file serves as a simplified launcher for the Family Tree CLI application. It streamlines the process of executing commands without the need to repeatedly use java -jar with the full path to the JAR file. Please replace the placeholder path in the script with the actual location of your family-tree-0.0.1-SNAPSHOT.jar file.

This batch file simplifies the execution of the Family Tree CLI application.

```
@echo off
java -jar <actual path to your JAR file> %*
```

Then it will work with below command

```
.\family-tree.bat <command>
```