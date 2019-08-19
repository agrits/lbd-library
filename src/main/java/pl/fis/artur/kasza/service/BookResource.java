package pl.fis.artur.kasza.service;

import java.util.Set;

import javax.persistence.Query;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.fis.artur.kasza.entity.Book;

@Path("book")
public class BookResource extends AbstractResource<Book>{

	@Override
	public Class<Book> getType() {
		return Book.class;
	}	
}
