package pl.fis.artur.kasza.service;

import javax.ws.rs.Path;

import pl.fis.artur.kasza.entity.Address;

@Path("address")
public class AddressResource extends AbstractResource<Address>{

	@Override
	public Class<Address> getType() {
		return Address.class;
	}
	
}
