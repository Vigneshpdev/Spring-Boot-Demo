package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService<?> bookService;
   //query param
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public List<Book> getBook
	(@RequestParam(value="yearOfPublics",required = false) Set<String> yop,
			@RequestParam(value="bookType",required = false) String bookType) {

		return bookService.getBooks(yop,bookType);
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	//path param
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Optional<Book> getBookById(@PathVariable("id") Integer bookId) {
		return bookService.getBookById(bookId);
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
	public Book updateBook(@PathVariable(value = "id") Integer bookId,@RequestBody Book updatingBook)  {
		System.out.print("Inside update method");
		return bookService.updateBook(bookId,updatingBook);
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable Integer id) {
		
		return bookService.deleteBook(id);
		
	}
	
	@GetMapping(value = "/raw/book")
	public List<Book> getRawQuery(@RequestParam(value = "yearOfPublics",required = false) Set<String> yop){
		
		return bookService.getRawQuery(yop);
		
	}

}
