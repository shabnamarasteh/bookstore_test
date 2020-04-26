package ir.test.bookstore.modules.users.service;

import ir.test.bookstore.modules.users.entity.Users;
import ir.test.bookstore.modules.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    public Users registerUser(Users users){
        return  this.usersRepository.save(users);
    }
    public List<Users> findAllUsers(){
        return this.usersRepository.findAll();
    }
}
