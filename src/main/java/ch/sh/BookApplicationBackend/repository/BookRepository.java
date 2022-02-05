package ch.sh.BookApplicationBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.sh.BookApplicationBackend.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	void deleteBookById(Long id);
}
