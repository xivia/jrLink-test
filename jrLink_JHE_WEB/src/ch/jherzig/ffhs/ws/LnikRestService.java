package ch.jherzig.ffhs.ws;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ch.jherzig.ffhs.controller.LinkBean;
import ch.jherzig.ffhs.model.Link;

@Path("service/link")
// @Statless wird benötigt sonst funktioniert das @EJB nicht
@Stateless
public class LnikRestService {

	@Context
	private UriInfo context;

	public LnikRestService() {
	}

	@EJB
	private LinkBean linkBean;

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response test() {
		String result = "Eine Liste vom LnikRestService <br>";

		Collection<Link> linkList = linkBean.getLinkList();

		for (Link link : linkList) {
			result = result + "Name: " + link.getName() + "<br>";
		}

		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/print/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Link produceJSON(@PathParam("id") String id) {

		Link link = linkBean.getByKey(Long.parseLong(id)); 

		return link;
	}
}
