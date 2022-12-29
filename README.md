# RBCTest
Clone the entire project to local repository - https://github.com/pratheeknshetty/RBCTest.git <br />
Open the project in IDE - IntelliJ<br />
Maven Clean > Install<br />
Open the file src/test/java/RBCTest/Hipolabs/runner/TestRunner.java and run the TestRunner <br />
You will have the Cucumber report link at the end of the Feature level test result<br />
Alternatively you can also open the file cucumber.html under target folder in any browser to see the report<br />
src/test/java/RBCTest/Hipolabs/runner/TestRunner.java - you can segregate and selectively execute tests based on the tags mentioned here<br />
src/test/resources/features/searchService.feature - you have the test cases written in simple gherkin along with the tags <br />
TO DO- We can also add parameter values in the .properties file instead of feature file<br />
TO Do- We can also have test environment specific parameter values in eac .properties files (Example qa1.properties, qa1.properties) - You can easily specify test environments in JUnit test configurations<br />
TO Do- We can add a Jules pipeline and Jenkins file where we can write groovy script to conditionally trigger these scripts and send emails with test reports <br />
