package com.spring.framework.spring5webapp.repositories;

import com.spring.framework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
