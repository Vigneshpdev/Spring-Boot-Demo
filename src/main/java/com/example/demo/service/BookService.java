package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;

@Service
public class BookService<S> {

	@Autowired
	private BookRepository bookRepositoy;

	public List<Book> getBooks(Set<String> yop, String bookType) {

		List<Book> bookList = new ArrayList<>();
		if (yop == null) {
			bookRepositoy.findAll().forEach(book -> bookList.add(book));
		} else if (bookType == null) {
			return bookRepositoy.findAllByYearOfPublicIn(yop);
		} else {
			return bookRepositoy.findAllByYearOfPublicInAndBookType(yop, bookType);
		}
		return bookList;
	}

	public Book createBook(Book book) {
		return bookRepositoy.save(book);

	}

	public Optional<Book> getBookById(Integer bookId) {

		return bookRepositoy.findById(bookId);
	}

	public Book updateBook(Integer bookId, Book updatingBook) {
		System.out.print("Inside update method");
		// Optional<Book> optionUpdateBook = bookRepositoy.findById(bookId);
		// Book updateBook = optionUpdateBook.get();
		Book updateBook = bookRepositoy.findById(bookId).orElse(null);
		updateBook.setName(updatingBook.getName());
		updateBook.setDesc(updatingBook.getDesc());
		updateBook.setBookType(updatingBook.getBookType());
		updateBook.setYearOfPublic(updatingBook.getYearOfPublic());
		return bookRepositoy.save(updateBook);
	}

	public String deleteBook(Integer id) {
		bookRepositoy.deleteById(id);
		return "Delete Successfully";
	}

	public List<Book> getRawQuery(Set<String> yop) {
		List<Book> bookDetails = bookRepositoy.getRawQueryByYear(yop);
		return bookDetails;
	}

}
