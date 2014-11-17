package ch.jherzig.ffhs.ws;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("ws")
public class Ws {

	@Context
	private UriInfo context;

	public Ws() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response test() {
		String result = "Hello Welt vom WS ";
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("hello/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(@PathParam("id") String id) {
		String result = "Hello: " + id;
		return Response.status(200).entity(result).build();
	}

	@PUT
	@Path("/book/{isbn}")
	public void addBook(@PathParam("isbn") String id,
			@QueryParam("name") String name) {
		
		System.out.println("addBook: " + id);

	}

	@DELETE
	@Path("/book/{id}")
	public void removeBook(@PathParam("id") String id) {

		System.out.println("removeBook: " + id);
	}

}
