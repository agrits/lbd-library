package pl.fis.artur.kasza.entity;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Survey extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  

	private long id;
	
	@NotNull
	@ManyToOne
	private LibraryUser user;
	
	@NotNull
	private String question;
	
	@NotNull
	private String answer;
	
	@NotNull
	@JsonbDateFormat("dd-MM-yyyy")

	private LocalDate date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LibraryUser getUser() {
		return user;
	}

	public void setUser(LibraryUser user) {
		this.user = user;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {  
		this.date = date;
	}
	
	
}
