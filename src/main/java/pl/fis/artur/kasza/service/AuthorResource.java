package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.Author;

@Path("author")
public class AuthorResource extends AbstractResource<Author>{

	@Override
	public Class<Author> getType() {
		return Author.class;
	}
	
	
}
