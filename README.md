# QA Automation engineer Java course
## Diplom 3 (Web application)
## Run
Tests

Set OS property`RUN_TESTS_IN_YANDEX`=`1` to run tests in yandex browser(driver must be in `/bin/yandexdriver`, binary - `/bin/yandex-browser-stable`)

```
mvn clean test
```
Allure report

```
mvn allure:serve
```

## Dependencies
|  | Version |
| ------ | ------ |
| Java  | 11 |
| Maven  | 4.0.0 |
| junit | 4.13.2 |
| rest-assured | 4.4.0 |
| selenium-java | 3.141.59 |
| webdrivermanager | 4.4.3 |
| allure-junit4 | 2.15.0 |
| allure-rest-assured | 2.15.0 |
| maven-surefire-plugin | 2.22.2 |
| allure | 2.15.0 |