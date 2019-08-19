package pl.fis.artur.kasza.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import pl.fis.artur.kasza.database.DSManager;
import pl.fis.artur.kasza.entity.AbstractEntity;

@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractResource<T extends AbstractEntity>{
	
	@Inject
	DSManager dsManager;
	protected EntityManager em;
	
	@Resource
	UserTransaction userTransaction;
	
	@SuppressWarnings("unchecked")
	@GET
	public List<T> getAll(@DefaultValue("id") @QueryParam("sort_by") String sortBy,
						@DefaultValue("asc") @QueryParam("mode") String mode,
						@DefaultValue("1=1") @QueryParam("filter_by") String filterBy){
		return (List<T>) dsManager.getEntityManager()
								.createQuery("SELECT x from "+
											getType().getName()+
											" x WHERE "+
											filterBy +
											" ORDER BY x."+
											sortBy+" "+
											mode)
								.getResultList();
	}
	
	@GET
	@Path("{id}")
	public T getOne(@PathParam("id") long id){
		return em.find(getType(), id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public T addOne(@Valid @RequestBody T instance) {
		try {
			userTransaction.begin();
			em.persist(instance);
			userTransaction.commit();
		}
		catch(Exception e) {
			try {
				userTransaction.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return instance;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public T updateOne(@Valid @RequestBody T instance) {
		try {
			userTransaction.begin();
			em.merge(instance);
			userTransaction.commit();
		}
		catch(Exception e) {
			try {
				userTransaction.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return instance;
	} 
	
	@DELETE
	@Path("{id}")
	public Response deleteOne(@PathParam("id") long id) throws Exception{
		try {
		T entity = getOne(id);
		userTransaction.begin();
		em.remove(em.merge(entity));
		userTransaction.commit();
		}
		catch(Exception e) {}
		return Response.ok().build();
	}
	
	public abstract Class<T> getType();
	
	
	
	@PostConstruct
	void init() {
		em = dsManager.getEntityManager();
	}
}
