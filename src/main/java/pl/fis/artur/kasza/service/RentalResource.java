package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.Rental;

@Path("rental")
public class RentalResource extends AbstractResource<Rental>{

	@Override
	public Class<Rental> getType() {
		return Rental.class;
	}

}
