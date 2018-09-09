# 159.251 Software Engineering Design and Construction
# Assignment 1

This assignment was jointly completed by: <br/>
Josh Fleet - 15390549 <br/>
Glen Ward - 13051097


*Note* **Task 1** Shell scripting file is named: list.sh and is located in this location: ./251-A1-Fleet-Josh/data/error_files . Please run script from here.

*Note* **Task 2** Certain buttons depend on files that are created when the script is run so please run the script before testing for Task 2

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
