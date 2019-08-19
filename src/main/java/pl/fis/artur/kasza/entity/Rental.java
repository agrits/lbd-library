package pl.fis.artur.kasza.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Rental extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	
	@NotNull
	@ManyToOne
	private Book book;
	
	@ManyToOne
	@NotNull
	private LibraryUser user;
	  
	@NotNull
	@JsonbDateFormat("dd-MM-yyyy")
	private LocalDate startDate;
	
	@JsonbDateFormat("dd-MM-yyyy")
	@NotNull
	private LocalDate endDate;
	 
	@JsonbDateFormat("dd-MM-yyyy")
	private LocalDate returnedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LibraryUser getUser() {
		return user;
	}

	public void setUser(LibraryUser user) {
		this.user = user;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

	
	
}
