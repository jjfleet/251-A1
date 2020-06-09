# 159.251 Software Engineering Design and Construction
# Assignment 1

This assignment was jointly completed by: <br/>
J Fleet 15390549 <br/>
G Ward - 13051097


*Note*
> **Task 1** - Shell scripting file is named: list.sh and is located in this location: ./251-A1.../data/files . Please run script from here.

*Note*
> **Task 2** - Certain buttons on the webpage depend on Task 1 files that are created when the script is run so please run the script before testing for Task 2

# Git Commit ID's

J Fleet
> 2616323021f015f7bca1a200127dc49bf7ad5f74 </br>
> 042be3799393d97708d4a4adf129ae6bfc6e8dcd

G Ward
> 15db0e595172705a5756f7290a51d77e939d000f </br>
> ac93c32b0bad0a5965c424541cb9d72a61c232f4

## Task 1: Shell scripting
Markdown format todo list files are in the `./251-A1.../data/files` directory.

## Task 2: Software Development
All .java project files are located in `./251-A1.../src/main/java/nz/ac/massey/cs`
### Running the web application
You will need to install [Apache Maven](https://maven.apache.org/) to manage the project.

Once you have Maven installed, you can run the development web server with the following commands:

```
cd <project_directory>
mvn clean; mvn test
mvn exec:java -Dexec.mainClass="nz.ac.massey.cs.Start" -Dexec.classpathScope=test
```

Application can be accessed on your web browser at `http://localhost:8080`
