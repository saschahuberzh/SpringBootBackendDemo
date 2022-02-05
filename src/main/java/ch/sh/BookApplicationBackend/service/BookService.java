package ch.sh.BookApplicationBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.sh.BookApplicationBackend.exception.UserNotFoundException;
import ch.sh.BookApplicationBackend.model.Book;
import ch.sh.BookApplicationBackend.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book addBook(Book book) {
		bookRepository.save(book);
		return book;
	}
	
	public List<Book> findAllBook(){
		return bookRepository.findAll();
	}
	
	public Book findBookById(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by id "+id+" was not found"));
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteBookById(id);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
}
