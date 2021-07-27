Spring Security Basic Authentication
     - dependency " spring-boot-starter-security " will add a login form based authentication which is the basic password based login control
     provided.
     
     *Basic Auth in Spring boot*
     - There are multiple ways to authenticate our RESTful web services. 
     The basic way is to use basic authentication. In the basic authentication, we send a username and password as part of our request. When we provide a username and password, it allows us to access the resource.
     - client sends a get request along with base 64 username:password, server sends a 200 status.
     without the username and password the resource is not accessible.
     - within the browser we get the username and passowrd pop up.
     -Refer class ApplicationSecurityConfig
     
     
Whitelist some URLs using ANT matchers
     
     * in case we want to whitelist certain URLs in our application so that the user does not have to provide a username 
     and password to access it, we can use antmatchers().permitAll()
     
Maintaning users in a Postgres database
     
     
     
     
     
     
     