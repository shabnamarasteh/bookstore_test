package ir.test.bookstore.modules.borrow.controller;

import ir.test.bookstore.modules.borrow.entity.Borrow;
import ir.test.bookstore.modules.borrow.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    private BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService){
        this.borrowService = borrowService;
    }

    @RequestMapping(value = {"/",""} , method = RequestMethod.GET)
    public List<Borrow> getBorrow(){
        return this.borrowService.findAllBorrow();
    }

    @RequestMapping(value = {"/",""} , method = RequestMethod.POST)
    public Borrow saveBarrow(Borrow borrow){
        return this.borrowService.saveBorrow(borrow);
    }
}
