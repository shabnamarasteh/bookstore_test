package ir.test.bookstore.modules.levels.conroller;

import ir.test.bookstore.modules.levels.entity.Levels;
import ir.test.bookstore.modules.levels.service.LevelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/levels")
public class LevelsController {
    private LevelsService levelsService;

    @Autowired
    public LevelsController(LevelsService levelsService){
        this.levelsService = levelsService;
    }

    @RequestMapping(value = {"/", ""} ,method = RequestMethod.GET)
    public List<Levels> getLevels(){
        return this.levelsService.findAllLevels();
    }

    @RequestMapping(value = {"/" , ""} , method = RequestMethod.POST)
    public Levels saveLevels(Levels levels){
        return this.levelsService.saveLevels(levels);
    }

}

