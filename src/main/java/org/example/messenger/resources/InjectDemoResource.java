package org.example.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("annotation")
public class InjectDemoResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getParamsUsingAnnotation(@MatrixParam(value = "value1") String matrixParam, @HeaderParam(value = "header_param") String header, @CookieParam(value = "cookieResponse") String cookieResponse) {
        return Response.ok().entity("Matrix Param : " + matrixParam + " header Param = " + header + " Cookie " + cookieResponse).cookie(new NewCookie("cookieResponse", "cookieValueInReturn")).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/formparam")
    public Response addUser(@FormParam("name") String name, @FormParam("age") String age) {
        return Response.ok().entity("Name = " + name + "and age = " + age).build();
    }

    @GET
    @Path("/context")
    @Produces(MediaType.TEXT_PLAIN)
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
        String cookies = httpHeaders.getCookies().toString();
        return "url = "+uriInfo.getAbsolutePath().toString() +" and cookies = "+cookies;
    }
}
