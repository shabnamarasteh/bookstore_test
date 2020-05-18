package ir.test.bookstore.modules.books.service;

import ir.test.bookstore.MyBeanCopy;
import ir.test.bookstore.modules.books.entity.Books;
import ir.test.bookstore.modules.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    public Books saveBooks(Books books) throws IOException, InvocationTargetException, IllegalAccessException {
        System.out.println(books.getId()+"---------------------");
        if(!books.getFile().isEmpty()){
            String path = ResourceUtils.getFile("classpath:static/img/books").getAbsolutePath();
            byte[] bytes = books.getFile().getBytes();
            String name = UUID.randomUUID()+ "." + Objects.requireNonNull(books.getFile().getContentType()).split("/")[1];
            Files.write(Paths.get(path+ File.separator +name) , bytes);
            books.setImage(name);
        }

        if(books.getId() != 0){
            Books exist = booksRepository.getOne(books.getId());
            MyBeanCopy myBeanCopy = new MyBeanCopy();
            myBeanCopy.copyProperty(exist,"book",books);
            return this.booksRepository.save(exist);
        }

        return this.booksRepository.save(books);
    }

    public List<Books> findAllBooks(){
        return this.booksRepository.findAll();
    }

    public Books findOne(long id) {
        if ( this.booksRepository.existsById(id)) {
            return this.booksRepository.getOne(id);
        } else {
            return new Books();
        }
    }
}