# 159.251 Software Engineering Design and Construction
# Assignment 1

This assignment was jointly completed by: <br/>
Josh Fleet - 15390549 <br/>
Glen Ward - 13051097


*Note*
> **Task 1** - Shell scripting file is named: list.sh and is located in this location: ./251-A1-Fleet-Josh/data/files . Please run script from here.

*Note*
> **Task 2** - Certain buttons on the webpage depend on Task 1 files that are created when the script is run so please run the script before testing for Task 2

# Git Commit ID's

Josh Fleet
> 2616323021f015f7bca1a200127dc49bf7ad5f74
> 042be3799393d97708d4a4adf129ae6bfc6e8dcd

## Task 1: Shell scripting
Markdown format todo list files are in the `./251-A1-Fleet-Josh/data/files` directory.

## Task 2: Software Development
All .java project files are located in `./251-A1-Fleet-Josh/src/main/java/nz/ac/massey/cs`
### Running the web application
You will need to install [Apache Maven](https://maven.apache.org/) to manage the project.

Once you have Maven installed, you can run the development web server with the following commands:

```
cd <project_directory>
mvn clean; mvn test
mvn exec:java -Dexec.mainClass="nz.ac.massey.cs.Start" -Dexec.classpathScope=test
```

Application can be accessed on your web browser at `http://localhost:8080`
