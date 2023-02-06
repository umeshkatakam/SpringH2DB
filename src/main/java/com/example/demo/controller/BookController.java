package com.example.demo.controller;

import com.example.demo.Model.Book;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/c")
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
		
		
		
		try{
			List<Book> books=repo.findAll();
			return new ResponseEntity<>(books,HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		
	}
	

	@GetMapping("/get/{id}")
		public ResponseEntity<Book> find(@PathVariable Long id){
		Optional<Book> book=repo.findById(id);
		
			if(book.isPresent())
				return new ResponseEntity(book,HttpStatus.OK);
			else
				return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
		
		@GetMapping("/find/{id}")
	public ResponseEntity<Book> getByid(@PathVariable("id") Long id){
		Book b=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found with id "+id));
		
		
		return new ResponseEntity<>(b,HttpStatus.OK);
		
	}
		

	
}
