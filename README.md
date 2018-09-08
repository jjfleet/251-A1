# 159.251 Software Engineering Design and Construction
# Assignment 1

This assignment was jointly completed by: <br/>
Josh Fleet - 15390549 <br/>
Glen Ward - 13051097

## Task 1: Shell scripting
Markdown format todo list files are in the `./data/files` directory.

## Task 2: Software Development
### Running the web application
You will need to install [Apache Maven](https://maven.apache.org/) to manage the project.

Once you have Maven installed, you can run the development web server with the following commands:

```
cd <project_directory>
mvn clean; mvn test
mvn exec:java -Dexec.mainClass="nz.ac.massey.cs.Start" -Dexec.classpathScope=test
```

Application can be accessed on your web browser at `http://localhost:8080`
