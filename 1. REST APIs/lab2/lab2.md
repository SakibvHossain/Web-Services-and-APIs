# Lab 2 

### Problem Encounter
+ org.springframework.data:spring-data-commons:jar:3.1.4 failed to transfer from https://repo.maven.apache.org/maven2 during a previous attempt. This failure was cached in the local repository and resolution is not reattempted until the update interval of central has elapsed or updates are forced. Original error: Could not transfer artifact org.springframework.data:spring-data-commons:jar:3.1.4 from/to central (https://repo.maven.apache.org/maven2): Connection reset
+ Unresolved dependency: 'org.springframework.data:spring-data-jpa:jar:3.1.4'

### How problem fixed
1. First, Configure the apache maven (apache-maven-3.9.5-bin.zip) also jdk must be 17 or higher.
2. Then, check ``mvn --version`` if the configuration setup done successfully then you'll see the version.
3. After that Open the project then run the following command on your terminal: ``mvn -X`` then ``mvn clean install``

Running ```mvn -X``` followed by ``mvn clean install`` is a good approach for troubleshooting and building your project.

By running ``mvn -X``, you enabled debug mode and obtained detailed output, which likely helped you identify and resolve the problem. Once the issue was fixed, running mvn clean install allowed Maven to perform a clean build of your project, ensuring that all dependencies are resolved and the project is compiled successfully.

This two-step process is often used to diagnose and fix build-related issues in Maven projects. The debug output from ``mvn -X`` can provide valuable information about the build process, and then running ``mvn clean install`` ensures a clean and reliable build.