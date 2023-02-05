package com.example.demo.service;

import java.util.List;

import javax.swing.event.ListDataEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Book;
import com.example.demo.repository.BookRepo;


@Service
public class BookService {

	
	@Autowired
	BookRepo repo;
	
	
	
	public ResponseEntity<Book> create(Book book) {
		// TODO Auto-generated method stub
		
		Book saveBook=repo.save(book);
		
		
		return ResponseEntity.accepted().body(saveBook);
	}
	
	public ResponseEntity<List<Book>> find(){
		
		List<Book> books=repo.findAll();		
		return ResponseEntity.ok().body(books);
	}
}
