package bookmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bookmanagement.models.Author;
import bookmanagement.models.Book;
import bookmanagement.persistance.AuthorReposistory;
import bookmanagement.persistance.BookReposistory;

@Controller
public class BookController {
	@Autowired
	BookReposistory bookRepo;
	@Autowired
	AuthorReposistory authorRepo;
	
	@RequestMapping("books")
	public String displayAll(ModelMap map) {
		
		List<Book> books=bookRepo.getAll();
	
		map.addAttribute("books", books); //model
		return "display_books"; //view
	}
	@GetMapping("addbook")
	public ModelAndView addBook(ModelMap map) {
		
//		Book newBook=new Book(); //for model
//		ModelAndView m_v=new ModelAndView("add_book","book",newBook);  //add_book is view name
//		return m_v;
		
		List<Author> authors=authorRepo.getAll();
		map.addAttribute("selected_authors",authors);
		
		return new ModelAndView("add_book","book",new Book()); //add_book is view name
	}
	@PostMapping("addbook")
	public String addBook(@ModelAttribute("book")@Validated Book book,BindingResult bResult,ModelMap map) {
		if (bResult.hasErrors()) {
			for(var a:book.getAuthors()) {
			System.out.println(a.getId()+" "+a.getName());
			}
//			map.addAttribute("error_msg",bResult.getFieldError());
			map.addAttribute("selected_authors",authorRepo.getAll());
			map.addAttribute("book",book);
			return "add_book";
		}
		int rs=bookRepo.add(book);
		if(rs==0) {
			map.addAttribute("book",book);
			map.addAttribute("error_msg", bResult.getFieldError());
			map.addAttribute("selected_authors",authorRepo.getAll());
			map.addAttribute("book",book);
			return "add_book";
		}else {
			return "redirect:/books"; // controller ကိုသွားမှာမို့လို့ redirect
		}	
	}
	@GetMapping("/deletebook/{code}")
	public String deleteBook(@PathVariable String code) {
		bookRepo.delete(code);
		return "redirect:/books"; 
	}
	@GetMapping("/editbook/{code}")
	public ModelAndView editBook(@PathVariable String code, ModelMap map) {
		Book book=bookRepo.getByCode(code);
		map.addAttribute("selected_authors",authorRepo.getAll());
		return new ModelAndView("edit_book","book",book);
		
		// 
//		System.out.println(book.getName()+" "+book.getPrice());
//		
//		Author a1=(Author)book.getAuthors().toArray()[0];
//		System.out.println("Book FirstAuthor: "+ a1.getId()+a1.getName());
//		
//		List<Author> allauthors=authorRepo.getAll();
//		for(var a : allauthors) {
//			System.out.println(a.getId()+a.getName());
//			System.out.println(a.equals(a1));
//		}
		
		
	}
	@PostMapping("/editbook")
	public String editBook(@ModelAttribute("book")@Validated Book book,BindingResult bResult,ModelMap map) {
		if (bResult.hasErrors()) {
//			map.addAttribute("error_msg",bResult.getFieldError());
			map.addAttribute("book",book);
			map.addAttribute("selected_authors",authorRepo.getAll());
			return "edit_book";
		}
		int rs=bookRepo.edit(book);
		if(rs==0) {
			map.addAttribute("error_msg", "SQL Update Error: ");
			map.addAttribute("book",book);
			return "edit_book";
		}else {
			return "redirect:/books"; 
	}
}
}
