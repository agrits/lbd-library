package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.LibraryUser;

@Path("user")
public class LibraryUserResource extends AbstractResource<LibraryUser>{

	@Override
	public Class<LibraryUser> getType() {
		return LibraryUser.class;
	}

}
