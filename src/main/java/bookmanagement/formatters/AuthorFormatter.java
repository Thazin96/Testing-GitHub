package bookmanagement.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import bookmanagement.models.Author;
import bookmanagement.persistance.AuthorReposistory;

public class AuthorFormatter implements Formatter<Author>{

	@Override
	public String print(Author object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author parse(String text, Locale locale) throws ParseException {
		AuthorReposistory repo = new AuthorReposistory();
		int id = Integer.parseInt(text);
		Author author = repo.getById(id);
		return author;
	}

	

}
