package pl.fis.artur.kasza.service;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.fis.artur.kasza.database.DSManager;
import pl.fis.artur.kasza.entity.Book;
import pl.fis.artur.kasza.entity.Rental;

@Path("statistics")
public class StatisticsResource {
	
	@Inject
	DSManager dsManager;
	
	private EntityManager em;
	

	
	@SuppressWarnings("unchecked")
	@GET
	@Path("popular/{month}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List getMostPopular(@PathParam("month") int month){
        Query query = this.em.createQuery("SELECT b, x.c from Book b right join (SELECT r.book.id as book_id, count(r.book.id) as c FROM Rental r "
        								+ "WHERE MONTH(startdate) = :month GROUP BY r.book.id) as x on x.book_id = b.id ORDER BY x.c desc"
        								);
        query.setParameter("month", month);
        List results = query.getResultList();
        Logger.getAnonymousLogger().info(results.toString());
		return results;
	}
	
	@PostConstruct
	void init() {
		this.em = dsManager.getEntityManager();
	}
}
