package ir.test.bookstore.modules.admins.service;

import ir.test.bookstore.modules.admins.entity.Admins;
import ir.test.bookstore.modules.admins.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class AdminsService {
    private AdminsRepository adminsRepository;

    @Autowired
    public AdminsService(AdminsRepository adminsRepository){
        this.adminsRepository = adminsRepository;
    }

    @Transactional
    public Admins save(Admins admins) throws IOException {
        String path = ResourceUtils.getFile("classpath:static/img/admin").getAbsolutePath();
        byte[] bytes = admins.getFile().getBytes();
        String imgname = UUID.randomUUID() + "."+ Objects.requireNonNull(admins.getFile().getContentType()).split("/")[1];
        Files.write(Paths.get(path+ File.separator + imgname) , bytes);
        admins.setImage(imgname);

        admins.setPassword(new BCryptPasswordEncoder().encode(admins.getPassword()));
        return this.adminsRepository.save(admins);
    }

    public List<Admins> findAllAdmins(){
        return this.adminsRepository.findAll();
    }

    public Optional<Admins> findOne(long id) {
       return this.adminsRepository.findById(id);
    }
}
