package com.weekFive.weekFiveDb.service;

import com.weekFive.weekFiveDb.model.Book;
import com.weekFive.weekFiveDb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            return bookRepository.save(book);
        }
        return null;
    }
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

  
    public long countBooks() {
        return bookRepository.count();
    }

    public void borrowBook(Long bookId) {
        Book book = getBookById(bookId);
        if (!book.isAvailable()) {
            throw new RuntimeException("Book already borrowed");
        }
        book.setAvailable(false);
        bookRepository.save(book);
    }


    public void returnBook(Long bookId) {
        Book book = getBookById(bookId);
        book.setAvailable(true);
        bookRepository.save(book);
    }

}


