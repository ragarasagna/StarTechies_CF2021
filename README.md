# StarTechies_CF2021
## BUG TRACKING SYSTEM
The project is an online bug tracking system for projects. The application allows software testers to report bugs for a project, project manager to view all bugs, assign bugs to developers and developers to update the bug status.


## Requirements:
List of dependencies that are needed to run the project on our system:

#### Database: MySQL:

        This is needed to store all the data collected from the user as well as the data that is required to run the application. There are four databases designed altogether. Firstly for the users i.e Project Manager, Developer, Testers. Secondly, we have a database of the projects. Thirdly, a database is maintained for the team formed by the project manager and lastly a database of bugs.
Download MySql from https://dev.mysql.com/downloads/

 
#### JAVA version 1.8 and above:

       Any version of Java above 1.8 can be installed directly from the web browser. The JDK and JRE are must for running our Java based application. 64-bit Eclipse needs a 64-bit JDK.


#### STS version 4.4.2 and above:

       Spring Tool Suite is an IDE to develop Spring applications. It is an Eclipse-based development environment. It provides a ready-to-use environment to implement, run, deploy, and debug the application.
Download Spring Tool Suite from https://spring.io/tools3/sts/all.

#### Eclipse version 4.6 and above:
       
      Eclipse is a Java-based application and, as such, requires a Java Runtime Environment or Java Development Kit (JRE or JDK) in order to run. Note that on recent versions of Mac, a full JDK needs to be installed, not just a JRE.
       While the Spring IDE project provides a set of plugins for the Eclipse IDE, the Spring Tool Suite comes as a ready-to-use distribution of the latest Eclipse releases with the Spring IDE components pre-installed. This includes the tc Server integration for Eclipse (another IDE extension that is provided by Pivotal as an open-source project) and various other additions to Eclipse that turn the pure Eclipse IDE into a ready-to-use, best-of-breed environment for enterprise Spring application development.
Download Eclipse from https://www.eclipse.org/downloads/packages/installer


#### Apache Tomcat version 8 and above:
  
     Tomcat is a web server (can handle HTTP requests/responses) and web container implements Java Servlet API. Any version above version 8 is best for running the HTTP page.
Download Tomcat from https://tomcat.apache.org/download-80.cgi

#### Required JAR files:

1. https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload/1.3



## Installation:
Step-by-step instruction on how to install your library…

Step 1: Configure a connection stream into a database

Step 2: Run the SQL file attached in the repository in your local system.

Step3: Create folder in C or D drive which will contain the JSON file.

## Usage:
The homepage contains three options:

1.Import Users  
2.Register  
3.Login

A new user needs to register themselves with their email id  and role,post which they will be directed to the login page.
The import users is used by the admin to include details of the users.
If the user is already registered he/she can directly login.

###### The project manager can perform a set of operations:

   1. Create new project and add members to the team.   
   2. Assign reported bugs to the developers
   3. Can manage the previously assigned projects and bug status.

###### The Tester can open a project assigned to him and click on report new bug.This will pass all the details of the bug to the Project Manager.

###### The Developer can open the Bug assigned ,resolve it and mark the status of the Bug as completed                   

## Contributers:
Gautami S Nair

Anindya Singhmar

Gaurav Pandey

Chaitanya Ashtekar

Raga Rasagna Paruchuri

Vandana Bora

Lokinendi Sai Harshita

Anuraag Ajaykummar

Mounika Kalakonda

Avirupa Saha
