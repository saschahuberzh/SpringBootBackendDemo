package ch.sh.BookApplicationBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.sh.BookApplicationBackend.model.Book;
import ch.sh.BookApplicationBackend.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book newBook = bookService.addBook(book);
		return new ResponseEntity<>(newBook, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.findAllBook();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Book> getBooks(@PathVariable("id") Long id) {
		Book book = bookService.findBookById(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(Book book) {
		Book newBook = bookService.updateBook(book);
		return new ResponseEntity<>(newBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
