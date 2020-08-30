package com.example.demo.repo;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	List<Book>	findAllByYearOfPublicInAndBookType(Set<String> yop,String bookType);
	
	List<Book>	findAllByYearOfPublicIn(Set<String> yop);
	
	String rawQuery="select * from book where year_of_public In ?1 ";
	
	@Query(nativeQuery = true,value = rawQuery)
	List<Book> getRawQueryByYear(Set<String> yop); 

}
