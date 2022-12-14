# cucumber-selenium-framework
```text
This framework test design is Behaviour Driven Design and Testing.
This framework supports Web, API Testing.
```
## Major Technologies
* Maven - Build
* TestNG - Unit testing
* [Cucumber](https://cucumber.io) - Behaviour Driven Design/Testing
* Selenium - Web test automation
* REST Assured API test automation
* Log4j2 - Logging framework
* Maven Cucumber Reporting - Beautiful cucumber reports
## Run Tests
### Maven
* **[Tutorial](https://qaautomation.expert/2021/03/26/run-cucumber-test-from-command-line/)**
* **[Cucumber command line options](https://cucumber.io/docs/cucumber/api/#options)**
* Run the following mvn command to install dependencies
```shell
mvn clean install -DskipTests
```
* **Run all Tests from Command Line**
```shell
mvn test
```
* **Running a Scenario using a Tag from Command Line**
```shell
mvn test -Dcucumber.filter.tags="@tag1"
```
* **Running Scenarios using Tags from Command Line**
```shell
mvn test -Dcucumber.filter.tags="@tag1 or @tag2"
```
* **Running a Scenarios using multiple Tags from Command Line**
  Note that only scenario's with both tags will run
```shell
mvn test -Dcucumber.filter.tags="@tag1 and @tag2"
```