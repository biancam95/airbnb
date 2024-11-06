# UI Automation Testing
Automation testing framework using Selenium, jUnit and Cucumber

## Build and Test
In terminal from root project folder, run command: mvn clean test

Working folder structure :
```
src
 |-- test
       |-- java
            |-- features - package contains feature file written in Cucumber
                  |-- *.feature
            |-- pages - package contains pages with their attributes and methods
                  |-- *.java
            |-- steps - package contains step definition
                  |-- *.java
                  
  |-- pom.xml

```
