API and Selenide Test Automation framework

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/Krosav4eg/SelenideProject/tree/master.svg?style=shield)](https://dl.circleci.com/status-badge/redirect/gh/Krosav4eg/SelenideProject/tree/master)

Local Setup:

    1.Clone this repository with git clone https://github.com/Krosav4eg/SelenideProject.git
    2.Make sure you have installed Maven & Allure on your PC
    3.This project uses Lombok for code generation during compilation. To make Lombok working:
        - Enable annotation processing in IDE settings;
        - Install Lombok plugin;
        - Restart IDE
    This Test Automation Framework built on JDK11, Selenide, Maven, Rest Assured and TestNG.

After doing the previous steps, in order to run tests in IntelliJ IDEA you need to:

    1.Go to src/test/java/tests -> select test class you need
    2.Right click -> Run 'test'
    3.Or use terminall command 'mvn clean test' to run all tests 
    4.In order to run specific suite, run following command: mvn clean test -Dsuite=<Suite name>
    5.To see allure report use 'mvn allure:serve allure:report' command in terminall