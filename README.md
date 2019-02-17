# springrepository
Repo for working on spring frameworks

This repository is working with spring framework related modules.

#JenkinsJunitProject
This project is a simple maven build project that uses Junit to run a test case.

****************STEPS TO DEPLOY AND RUN THE JOB ******************************
1. Place the pom.xml under the Jenkins workspace of this job or provide the location of pom.xml to your custom directory.
2. In the build execution step provide as below
    a. Select Invoke Top level Maven Targets
        Goal --> test
    b. Click on advanced
        POM --> leave blank if pom.xml is placed under default Jenkins Job workspace folder or provide the location to your folder
****************END OF STEPS TO DEPLOY AND RUN THE JOB ******************************


#JenkinsPrerequisitesProject
This project is a simple maven build project is used to perform a prerequisites db check to see if db is available before performing any activity.

****************STEPS TO DEPLOY AND RUN THE JOB ******************************
1. Place the jar JenkinsPrerequisitesProject.jar under the Jenkins workspace of this job.
2. In the build execution step provide as below
    java -jar JenkinsPrerequisitesProject.jar
****************END OF STEPS TO DEPLOY AND RUN THE JOB ******************************

#SpringSecurity
This is a simple maven build project used to achieve security on web applications using Spring Security features. 
This project has following features :-

1. Using Spring Security default Login process.
2. Using Spring Security Custom Login process.
3. Using Spring Security Custom Login/Logout process.
4. Using Spring Security enabling access based on hardcoded username,password and roles.
5. Using Spring Security enabling access based on username,password and roles stored in database.
6. Using Spring Security storing text based plain password for authentication.
7. Using Spring Security storing encrypted password for authentication.

****************STEPS TO DEPLOY AND RUN THE APPLICATION ******************************
1. Run the sql statements from DB_scripts.txt for creating tables and data required for storing username, password and roles.
2. Import the project into workspace and build the war file using "mvn clean install" command.
3. Deploy the generated war file named  SpringSecurity.war (under /target folder) onto your choice of server.

****************END OF STEPS TO DEPLOY AND RUN THE APPLICATION ******************************
