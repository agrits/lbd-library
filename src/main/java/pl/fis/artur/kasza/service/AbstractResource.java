package pl.fis.artur.kasza.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.fis.artur.kasza.database.DSManager;
import pl.fis.artur.kasza.entity.AbstractEntity;
import pl.fis.artur.kasza.entity.Author;

public abstract class AbstractResource<T extends AbstractEntity>{
	
	@Inject
	DSManager dsManager;
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> getAll(){
		return (List<T>) dsManager.getEntityManager()
								.createQuery("SELECT x from "+getType().getName()+" x")
								.getResultList();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public T getOne(@PathParam("id") long id){
		return dsManager.getEntityManager().find(getType(), id);
	}
	
	public abstract Class<T> getType();

}
