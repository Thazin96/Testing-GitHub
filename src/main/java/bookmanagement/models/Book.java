package bookmanagement.models;
import java.util.ArrayList;
import java.util.List;

//Book DTO (Data Transfer Object)
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class Book {
	@NotEmpty
	private String code;
	@NotEmpty
	private String name;
	@Range(min=100,max=100000)
	private double price;
	
	List<Author> authors = new ArrayList<>();
	
	
	

	public Book() {
		
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return this.code + " : " + this.name +" : "+this.price+" $ ";
	}
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
