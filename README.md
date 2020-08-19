# BPDTS Test App v3

This project is a standalone Spring Boot Microservice that acts as a client to the backend BPDTS test app v3 service.

Maven 3 is used to run the unit tests and build the code.  The project contains a handful of junit tests primarily just to demostrate mocking objects in a dependency injection environment.

The Spring Boot container can be started using Maven as follows:

mvn spring-boot:run

Once running, my service can be accessed at:

http://localhost:8080/users/nearlondon 


The code retrieves the users in London then also checks all users for those that live near London.  Finally merging the two Lists.

With the current dataset the following 7 user results are returned from my service:

[{"id":135,"first_name":"Mechelle","last_name":"Boam","email":"mboam3q@thetimes.co.uk","ip_address":"113.71.242.187","latitude":-6.5115909,"longitude":105.652983,"city":null},{"id":396,"first_name":"Terry","last_name":"Stowgill","email":"tstowgillaz@webeden.co.uk","ip_address":"143.190.50.240","latitude":-6.7098551,"longitude":111.3479498,"city":null},{"id":520,"first_name":"Andrew","last_name":"Seabrocke","email":"aseabrockeef@indiegogo.com","ip_address":"28.146.197.176","latitude":27.69417,"longitude":109.73583,"city":null},{"id":658,"first_name":"Stephen","last_name":"Mapstone","email":"smapstonei9@bandcamp.com","ip_address":"187.79.141.124","latitude":-8.1844859,"longitude":113.6680747,"city":null},{"id":688,"first_name":"Tiffi","last_name":"Colbertson","email":"tcolbertsonj3@vimeo.com","ip_address":"141.49.93.0","latitude":37.13,"longitude":-84.08,"city":null},{"id":794,"first_name":"Katee","last_name":"Gopsall","email":"kgopsallm1@cam.ac.uk","ip_address":"203.138.133.164","latitude":5.7204203,"longitude":10.901604,"city":null},{"id":266,"first_name":"Ancell","last_name":"Garnsworthy","email":"agarnsworthy7d@seattletimes.com","ip_address":"67.4.69.137","latitude":51.6553959,"longitude":0.0572553,"city":null}]