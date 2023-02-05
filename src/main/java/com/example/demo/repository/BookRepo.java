package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

 

}
