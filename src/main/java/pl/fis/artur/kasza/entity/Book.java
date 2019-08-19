package pl.fis.artur.kasza.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Book extends AbstractEntity{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	
	private long id;
	
	@NotNull
	private boolean rented;
	
	@NotNull
	private String title;
	
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Author> authors;
	
	@NotNull
	private String ISBN;
	
	@Column(columnDefinition = "TEXT") 
	private String description;
	
	@NotNull
	private short year;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Category> categories;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
}
