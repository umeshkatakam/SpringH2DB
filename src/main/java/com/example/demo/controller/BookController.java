package com.example.demo.controller;

import com.example.demo.Model.Book;
import com.example.demo.repository.BookRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;

@RestController()
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookRepo repo;
	
	@Autowired
	BookService service;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/dummy")
	public String create() {
		Book b= new Book(1L, "spring", 45, "umesh");
		
		repo.save(b);
		return "created";
	}
	
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		return service.create(book);
	}
	
	@GetMapping("/get")
	
	public ResponseEntity<List<Book>> findAll(){
		
		return service.find();
	}
	
	
	
}