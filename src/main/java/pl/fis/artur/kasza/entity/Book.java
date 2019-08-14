package pl.fis.artur.kasza.entity;


import java.util.List;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

public class Book extends AbstractEntity{
	
	private long id;
	
	@NotNull
	private boolean rented;
	
	@NotNull
	private String title;
	
	@NotNull
	@ManyToMany
	private List<Author> authors;
	
	@NotNull
	private String ISBN;
	
	private String description;
	
	@NotNull
	private short year;
	
	@NotNull
	@ManyToMany
	private List<Category> categories;

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

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
