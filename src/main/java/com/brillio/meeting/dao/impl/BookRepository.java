package com.brillio.meeting.dao.impl;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.meeting.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findById(int id);
}