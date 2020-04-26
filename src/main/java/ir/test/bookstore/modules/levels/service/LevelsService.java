package ir.test.bookstore.modules.levels.service;

import ir.test.bookstore.modules.levels.entity.Levels;
import ir.test.bookstore.modules.levels.repository.LevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelsService {
    private LevelsRepository levelsRepository;

    @Autowired
    public LevelsService(LevelsRepository levelsRepository){
        this.levelsRepository = levelsRepository;
    }

    public Levels saveLevels(Levels levels){
        return this.levelsRepository.save(levels);
    }

    public List<Levels> findAllLevels(){
        return this.levelsRepository.findAll();
    }

}
