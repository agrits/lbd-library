package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.Book;

@Path("book")
public class BookResource extends AbstractResource<Book>{

	@Override
	public Class<Book> getType() {
		return Book.class;
	}
	
}
