# Lab 1 (Solution)
### Step 1: Use Spring Initializr to bootstrap a simple project.
+ Add the H2 Database, Spring Web Starter, and the Spring Data JPA dependencies before generating the project.

### Step 2: Set up the H2 in-memory database.
1. Open the application.properties file in your project.
2. Add the following properties to configure the H2 database:
  ```
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  spring.h2.console.enabled=true
  spring.h2.console.path=/h2-console
  ```
 - ``spring.datasource.url``: This property specifies the JDBC URL for the H2 database. In this example, we are using an in-memory database with the name testdb.

 - ``spring.datasource.driverClassName``: This property specifies the driver class for the H2 database.

 - ``spring.datasource.username`` and ``spring.datasource.password``: These properties specify the username and password for the H2 database. In this example, we are using the default values, where the username is sa and the password is empty.

 - ``spring.h2.console.enabled``: This property enables the H2 console, which provides a web-based interface to interact with the H2 database.

 - ``spring.h2.console.path``: This property specifies the URL path for accessing the H2 console. In this example, the console will be available at ``/h2-console``.

With these configurations, your application will be able to connect to the H2 database using the specified URL, driver class, username, and password. You can also access the H2 console by navigating to the specified path in your web browser.


### To unstage  file using git
``git restore --staged <file>...``
### To delete file
``git rm <file>``
### To update CHANGELOG.md
`` git log --pretty="- %s" > CHANGELOG.md``