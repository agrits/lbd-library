package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.Country;

@Path("country")
public class CountryResource extends AbstractResource<Country>{

	@Override
	public Class<Country> getType() {
		return Country.class;
	}

}
