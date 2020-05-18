package ir.test.bookstore.modules.levels.service;
import ir.test.bookstore.MyBeanCopy;
import ir.test.bookstore.modules.levels.entity.Levels;
import ir.test.bookstore.modules.levels.repository.LevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class LevelsService {
    private LevelsRepository levelsRepository;

    @Autowired
    public LevelsService(LevelsRepository levelsRepository){
        this.levelsRepository = levelsRepository;
    }

    public Levels saveLevels(Levels levels) throws IOException, InvocationTargetException, IllegalAccessException {
        if(!levels.getFile().isEmpty()){
            String path = ResourceUtils.getFile("classpath:static/img/levels").getAbsolutePath();
            byte[] bytes = levels.getFile().getBytes();

            String name = UUID.randomUUID()+ "." + Objects.requireNonNull(levels.getFile().getContentType()).split("/")[1];
            Files.write(Paths.get(path+ File.separator +name) , bytes);
            levels.setCover(name);
        }

        if(levels.getId() != 0){
            Levels exist = levelsRepository.getOne(levels.getId());
            MyBeanCopy myBeanCopy = new MyBeanCopy();
            myBeanCopy.copyProperty(exist,"levels",levels);
            return this.levelsRepository.save(levels);
        }
        return this.levelsRepository.save(levels);
    }

    public List<Levels> findAllLevels(){
        return this.levelsRepository.findAll();
    }

    public Levels findOne(long id) {
        return this.levelsRepository.getOne(id);
    }
}
