package pl.fis.artur.kasza.database;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.fis.artur.kasza.entity.Author;
import pl.fis.artur.kasza.entity.Country;
import pl.fis.artur.kasza.entity.City;

@Singleton
public class DSManager {
	
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEntityManager() {
		return this.em;  
	}
	
	@PostConstruct
	void init(){
		for(int i = 0; i<10; i++) {
			Author a = new Author();
			a.setFirstName("Adam"+i);
			a.setLastName("Sandler");
			this.em.persist(a);
		}
		Country poland = new Country();
		
		poland.setName("Poland");
		poland.setPrefix("+48");
		City c = new City();
		c.setName("Warszawa");
		c.setCountry(poland);
		
		em.persist(poland);
		em.persist(c);
	} 
}
