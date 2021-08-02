Spring Security Basic Authentication
 
 Dependency " spring-boot-starter-security " will add a login form based authentication which is the basic password based login control
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
     
Maintaining users in InMemoryUserDetails
    
    * override userDetailsService() from WebSecurityConfigurerAdapter
    * create a user (annasmith) and password
    * create a PasswordConfig which returns the encrypted password
    * use the encrypted password to build the username and password
    
Roles and Permissions
    
    
    * Role based authentication- using hasRole(): For an api to be accessed from a particular role only. use ant matcher with the api url from controller (/api/v1/student)
                      
                      antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
    

    * Permission based authentication- using hasAuthority() : use hasAuthority() to define what method calls are allowed for an API for what all persmissions
    
    
                      // for permission based authentication use hasAuthority()
                      // for example, linda is an admin, she has permissions to read and write a course. 
                      // So we can define in the hasAuthority() method, the user with the specific permissions can access the api
                      .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())
                      .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.name())
                      .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.name())
                      .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermissions.COURSE_WRITE.name())
                        
                      ApplicationRoles.getAuthorties() method will provide the permissions to the respective roles at runtime.
                      In the Application security config class, every user is role aware. in order to have the authorities assigned at runtime, we will use the grantedAuthorities() method. 
 
Order of antMatchers matters

Use of permission based authentication on a method level with annotations - @preAuthorize - alternate to antMatchers()

Understanding csrf - cross site request forgery
                    
                      *  refer the screenshot below
                      
     
Json Web Token
              
              Adv      * Fast
                       * Stateless - no need to maintain session
                       * Used across many services
                       
                      
              DisAdv    
                       * compromised secret key
                       * no visibility to logged in users
                       * token can be stolen
              
              Consists of header, payload and verfify signature sections         
     