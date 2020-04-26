package ir.test.bookstore.modules.borrow.service;

import ir.test.bookstore.modules.borrow.entity.Borrow;
import ir.test.bookstore.modules.borrow.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {
    private BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository){
        this.borrowRepository = borrowRepository;
    }

    public Borrow saveBorrow(Borrow borrow){
        return this.borrowRepository.save(borrow);
    }
    public List<Borrow> findAllBorrow(){
        return this.borrowRepository.findAll();
    }

}
