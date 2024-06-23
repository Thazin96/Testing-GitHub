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
import bookmanagement.persistance.AuthorReposistory;
@Controller
public class AuthorController {
	@Autowired
	AuthorReposistory authorRepo; //database ကို ခေါ်တာ
	
	@RequestMapping("authors")
	public String displayAll(ModelMap map) {
		
		List<Author> authors=authorRepo.getAll();
	
		map.addAttribute("authors", authors); //model
		return "display_author"; //view
	}
	@GetMapping("addauthor")
	public ModelAndView addAuthor() {
		return new ModelAndView("add_author","author",new Author());
	}
	@PostMapping("addauthor")
	public String addAuthor(@ModelAttribute("author")@Validated Author author,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "add_author";
		}
		int rs=authorRepo.add(author);
		if(rs==0) {
			map.addAttribute("author",author);
			map.addAttribute("error_msg","Database something wrong");
			return "add_author";
		}else {
				return "redirect:/authors";
		}
	}
	@GetMapping("editauthor/{id}")
	public ModelAndView editAuthor(@PathVariable int id) {
		Author author = authorRepo.getById(id);
		return new ModelAndView("edit_author","author",author);
	}
	@PostMapping("editauthor")
	public String editAuthor(@ModelAttribute("author")@Validated Author author,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "edit_author";
		}
		int rs=authorRepo.edit(author);
		if(rs==0) {
			map.addAttribute("error_msg","In Updating, Database something wrong");
			return "edit_author";
		}else {
				return "redirect:/authors";
		}
	}
	@GetMapping("deleteauthor/{id}")
	public String deleteAuthor(@PathVariable int id) {
		authorRepo.delete(id);
		return "redirect:/authors";
	}
}
