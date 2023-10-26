# Lab 2

### #1 Problem occurs
1. org.springframework.data:spring-data-commons:jar:3.1.4 failed to transfer from https://repo.maven.apache.org/maven2 during a previous attempt. This failure was cached in the local repository and resolution is not reattempted until the update interval of central has elapsed or updates are forced. Original error: Could not transfer artifact org.springframework.data:spring-data-commons:jar:3.1.4 from/to central (https://repo.maven.apache.org/maven2): Connection reset
2. Unresolved dependency: 'org.springframework.data:spring-data-jpa:jar:3.1.4'

### #1 Problem fixed
1. First, Configure the apache maven (apache-maven-3.9.5-bin.zip) also jdk must be 17 or higher.
2. Then, check ``mvn --version`` if the configuration setup done successfully then you'll see the version.
3. After that Open the project then run the following command on your terminal: ``mvn -X`` then ``mvn clean install``

Running ```mvn -X``` followed by ``mvn clean install`` is a good approach for troubleshooting and building your project.

By running ``mvn -X``, you enabled debug mode and obtained detailed output, which likely helped you identify and resolve the problem. Once the issue was fixed, running mvn clean install allowed Maven to perform a clean build of your project, ensuring that all dependencies are resolved and the project is compiled successfully.

This two-step process is often used to diagnose and fix build-related issues in Maven projects. The debug output from ``mvn -X`` can provide valuable information about the build process, and then running ``mvn clean install`` ensures a clean and reliable build.



### How table created and inserted on database internal detail with high-level overview
1. **Application Startup**: When you run the Spring Boot application, it initializes the necessary components and configurations.
2. **Component Scanning**: Spring Boot scans for components, such as controller, services, and repositories, using annotations like ```@RestController```, ```@Services```, ``@Repository``, and ``@Entity``. This allows Spring to identify and manage these components.
3. **Dependency Injection**: Spring Boot uses dependency injection to inject dependencies into the components. For example, in the `DogController` class, the `DogService` dependency is injected using `@Autowired`.
4. **Request Mapping**: Once the application is initialized, it starts listening for incoming HTTP requests. When a request is received, Spring Boot maps the request to the appropriate controller method based on the URL and HTTP method specified in the `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc. annotations.
5. **Controller Execution**: The mapped controller method is executed, performing the necessary logic and interacting with other components, such as services or repository.
6. **Response Generation**: After the controller method completes its execution, it returns a response to the client. This response can be in various formats, such as JSON, XML, or HTML, depending on the configuration and the annotations used.
7. The ``data.sql`` file execution happens during the application startup process, before the controller is reached. 

Simply if I said about `data.sql` only then, After running the spring boot application it reads `application.properties` to configure the database then looks for `data.sql` file which is executed by the application database initialization mechanism. This mechanism provided by spring boot framework. Once the `data.sql` is executed successfully then table created which populated with specified data.

### #2 Problem occurs
1. ```data.sql```: The sql query that I have written was perfectly working on other project. But on this project it creates table but not inserted data on the table.
2. ``DogNotFoundException.java``: This class is used to handle error. If an id is requested that doesn’t exist, appropriately handle the error. But when I run the application and enter the wrong id the message doesn't appear.

### #2 Problem Fixed
1. ``data.sql``: What I have done here is I have written query one after another like after create table query I have provided insert query. Than I create separate file for insertion(`schema.sql`) and creation(`data.sql`) now it's working perfectly also added this (`spring.jpa.hibernate.ddl-auto=none`) configuration at `application.properties`. Why because this ensures the schema.sql is picked up and the create scripts are executed.
2. ``DogNotFoundException.java``: To fix this issue. I did the following:
 Added this lines to DogController:
   ```
   @ExceptionHandler(value= DogNotFoundException.class)
   public ResponseEntity<String> returnNotFoundException(DogNotFoundException ex){
   return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
   }
   ```
   after this I added the following line on DogServiceImpl:
   ``
    optionalBreed.orElseThrow(() -> new DogNotFoundException("Breed not found")); 
   ``

### #3 Problem occurs & fix (Naming Convention matters)
While creating database keep in mind that The naming convention for database initialization scripts in a Spring Boot application is important. By default, Spring Boot looks for two specific files: `schema.sql` and `data.sql`.
The `schema.sql` file is used for creating the database schema, including tables, indexes, and constraints. It is executed once during the application startup.

The `data.sql` file, on the other hand, is used for inserting data into the database. It is executed every time the application starts up, after the schema.sql file.

When you named your files create_data.sql and insert_data.sql, Spring Boot was not able to find them automatically during the initialization process. So, To make your custom-named scripts work, you can configure Spring Boot to look for them explicitly. You can do this by specifying the file names in your application.properties.
For example, if you want to use create_data.sql for schema creation and insert_data.sql for data insertion, you can add the following configuration in your application.properties file:

```
spring.datasource.schema=classpath:create_data.sql
spring.datasource.data=classpath:insert_data.sql
```

By providing these configurations, Spring Boot will use your custom-named scripts instead of the default `schema.sql` and `data.sql` files.