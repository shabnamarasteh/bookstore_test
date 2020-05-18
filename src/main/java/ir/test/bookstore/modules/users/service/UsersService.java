package ir.test.bookstore.modules.users.service;

import ir.test.bookstore.MyBeanCopy;
import ir.test.bookstore.modules.users.entity.Users;
import ir.test.bookstore.modules.users.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    public Users saveUsers(Users users) throws InvocationTargetException, IllegalAccessException {
        if(!users.getPassword().isEmpty()){
            users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
        }

        if(users.getId() != 0 ){
            Users exist = usersRepository.getOne(users.getId());
            MyBeanCopy myBeanCopy = new MyBeanCopy();
            myBeanCopy.copyProperty(exist,"users",users);
            return this.usersRepository.save(exist);
        }

        return this.usersRepository.save(users);
    }

    public Users registerUser(Users users){
        return  this.usersRepository.save(users);
    }

    public List<Users> findAllUsers(){
        return this.usersRepository.findAll();
    }

    public Users findOneUser(long id) {
        if ( this.usersRepository.existsById(id)) {
            return this.usersRepository.getOne(id);
        } else {
            return new Users();
        }
    }
}
