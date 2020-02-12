package com.spring.framework.spring5webapp.bootstrap;

import com.spring.framework.spring5webapp.model.Author;
import com.spring.framework.spring5webapp.model.Book;
import com.spring.framework.spring5webapp.model.Publisher;
import com.spring.framework.spring5webapp.repositories.AuthorRepository;
import com.spring.framework.spring5webapp.repositories.BookRepository;
import com.spring.framework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData   implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("RPG Publications");
        publisher.setAddressLine1("12 cross st.");
        publisher.setCity("India");
        publisher.setState("Chennai");
        publisher.setZip("600203");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","12123214356344213123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Publications: " + publisherRepository.count());
        System.out.println("Publications Number of Books: " +publisher.getBooks().size());
    }
}
