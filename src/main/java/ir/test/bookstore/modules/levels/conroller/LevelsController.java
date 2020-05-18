package ir.test.bookstore.modules.levels.conroller;

import ir.test.bookstore.modules.levels.entity.Levels;
import ir.test.bookstore.modules.levels.service.LevelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LevelsController {
    private LevelsService levelsService;

    @Autowired
    public LevelsController(LevelsService levelsService){
        this.levelsService = levelsService;
    }

    @RequestMapping(value = {"/levels", "/levels/"} , method = RequestMethod.GET)
    public String levelList(Model model){
        model.addAttribute("levels" , this.levelsService.findAllLevels());
        return "admin/levels/list";
    }

    @RequestMapping(value = {"/levels/register", "/levels/register/"} , method = RequestMethod.GET)
    public String levelRegisterform(Model model){
        model.addAttribute("level" , new Levels());
        return "admin/levels/register";
    }

    @RequestMapping(value = {"/levels/register", "/levels/register/"} , method = RequestMethod.POST)
    public String levelRegister(@ModelAttribute Levels levels) throws IllegalAccessException, IOException, InvocationTargetException {
         this.levelsService.saveLevels(levels);
        return "redirect:/admin/levels/";
    }

    @RequestMapping(value = {"/levels/edit/{id}", "/levels/edit/{id}/"} , method = RequestMethod.GET)
    public String levelEditform(Model model, @PathVariable("id") long id){
        model.addAttribute("level" , this.levelsService.findOne(id));
        return "admin/levels/register";
    }

    @RequestMapping(value = {"/rest/levels", "/rest/levels/"} , method = RequestMethod.GET)
    public List<Levels> getLevels(){
        return this.levelsService.findAllLevels();
    }

    @RequestMapping(value = {"/rest/levels", "/rest/levels/"} , method = RequestMethod.POST)
    public Levels saveLevels(Levels levels) throws IllegalAccessException, IOException, InvocationTargetException {
        return this.levelsService.saveLevels(levels);
    }

}

