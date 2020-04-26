package ir.test.bookstore.modules.books.service;

import ir.test.bookstore.modules.books.entity.Books;
import ir.test.bookstore.modules.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class BooksService {
    private BooksRepository booksRepository;
    @Autowired
    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    @Transactional
    public Books saveBooks(Books books) throws IOException {
        String path = ResourceUtils.getFile("classpath:static/img").getAbsolutePath();
        byte[] bytes = books.getFile().getBytes();
        String name = UUID.randomUUID()+ "." + Objects.requireNonNull(books.getFile().getContentType()).split("/")[1];
        Files.write(Paths.get(path+ File.separator +name) , bytes);
        books.setCover(name);
        return this.booksRepository.save(books);
    }

    public List<Books> findAllBooks(){
        return this.booksRepository.findAll();
    }

    public Optional<Books> findOne(long id) {
        Optional<Books> books = this.booksRepository.findById(id);
        return books;
    }
}
