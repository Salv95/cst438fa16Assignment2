
package edu.csumb.cst438fa16qa.rest;

import edu.csumb.cst438fa16qa.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST service that greets requests.
 *
 * This is a "root resource class" as explained in
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */



@Path("/")
public class qaService{
    
    

    public static QuestionsAnswers qa1 = new QuestionsAnswers();
    
    
    
    @GET
    @Path("/randomquestion")
    public String getRandomQuestion(){
        
        qa1.put("Is the sky blue?", "yes");
        qa1.put("What color is snow?", "white");
        qa1.put("Who Framed Roger Rabbit?", "judge doom");
        
        return qa1.getRandomQuestion();
    }
    
    @GET
    @Path("/testanswer")
    public Response testanswer(@QueryParam("randomQues") String randomQues, @QueryParam("randomAns") String randomAns){
        
        if ((randomQues == null || randomQues.isEmpty()) || (randomAns == null || randomAns.isEmpty())) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(qa1.testAnswer(randomQues, randomAns)).build();
        }

    }


    
}

/*

@Path("/")
public class HelloService {
    @GET
    @Path("/today")
    public String today() {
	return DayOfWeek.today();
    }

    @GET
    @Path("/hello")
    public Response hello(@QueryParam("name") String name) {
        if (name == null || name.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok("hello " + name).build();
        }
    }
}
*/