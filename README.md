# feeds
Project for collecting feeds from url in different formats


The solution has basically 3 parts:
1- Database. The attached script .sql feedsCreate.sql is used. This script generates a database named feedDB. From there, a feed table is generated in which all the fields of the solution are stored.

2- serverfeedTasks: It is the Java project: serverfeedTasks. Basically, the first thing to do is configure the database user and password in the application.properties file. From there they have developed a REST service that, using a post method, inserts the feed data into the database from the input url.
For storing data , Spring Boot JPA has been used. There is a FeedRepository class and Feed class for storing feeds in the sql data base . There has also been developed a user class and User Repository in case it would be necessary user asministration.
An example of a request would be the following:
curl localhost: 8080 /feed/url -d url = "http://feeds.nos.nl/nosjournaal?format=xml"
 The server runs on port 8080. To run the server, the attached feedsData.jar file would be passed.
 The server is based on Spring-Boot Rest Services which parses the GET and POST Responses. There is a class which has a method for parsing the xml file and obtain all the information.
 This class can be added methods for url parsing in different formats (json).
3-Client: it is the cron that is executed, based on the SpringBoot Scheduler which calls the REST Services in a period of configurable. It is the client part.
For launching the project we will need to start the server first and theen start the client and all the data will be stored in the DATABASE.




