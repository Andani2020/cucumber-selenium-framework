# cucumber-selenium-framework
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

```
