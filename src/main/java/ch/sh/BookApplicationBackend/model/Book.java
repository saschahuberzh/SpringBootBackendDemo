package ch.sh.BookApplicationBackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int pages;
	
	public Book(Long id, String name, int pages) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
	}
	
	public Book() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pages=" + pages + "]";
	}
	
}
