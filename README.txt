Runners are able (divided by modules):
1. TestNG
2. Junit
3. Cucumber

To run test from command line by testNG (by default testng.xml will be used):
write from testNG folder
mvn test

To run test from command line by Cucumber write from cucumber folder:
mvn clean test
mvn verify -DskipTests