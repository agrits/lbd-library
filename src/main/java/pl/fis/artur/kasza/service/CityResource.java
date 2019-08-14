package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.City;

@Path("city")
public class CityResource extends AbstractResource<City>{

	@Override
	public Class<City> getType() {
		return City.class;
	}

}
