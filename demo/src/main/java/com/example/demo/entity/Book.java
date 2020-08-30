package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(name = "description")
	private String desc;
	private String yearOfPublic;
	private String bookType;
	
	public Book() {
		
	}
	
	public Book(Integer id, String name, String desc, String yearOfPublic, String bookType) {

		this.id = id;
		this.name = name;
		this.desc = desc;
		this.yearOfPublic = yearOfPublic;
		this.bookType = bookType;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getYearOfPublic() {
		return yearOfPublic;
	}

	public void setYearOfPublic(String yearOfPublic) {
		this.yearOfPublic = yearOfPublic;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	

}
