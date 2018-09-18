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

