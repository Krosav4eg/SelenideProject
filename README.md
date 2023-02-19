Test Automation framework for listings-ui-api-automation

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/Krosav4eg/SeleniumProject/tree/master.svg?style=shield)](https://dl.circleci.com/status-badge/redirect/gh/Krosav4eg/SeleniumProject/tree/master)

Local Setup:

    1.Clone this repository with git clone https://github.com/Krosav4eg/SeleniumProject.git
    2.Make sure you have installed Maven & Allure on your PC
    3.This project uses Lombok for code generation during compilation. To make Lombok working:
        - Enable annotation processing in IDE settings;
        - Install Lombok plugin;
        - Restart IDE
    This Test Automation Framework built on JDK8, Maven, Rest Assured and TestNG.

After doing the previous steps, in order to run tests in IntelliJ IDEA you need to:

    1.Go to src/test/java/tests -> select test class you need
    2.Right click -> Run 'test'
    3.Or use terminall command 'mvn clean test' to run test suit 
    4.To see allure report use 'mvn allure:serve allure:report' command in terminall