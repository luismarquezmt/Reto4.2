package Reto.Ciclo339.web;

import Reto.Ciclo339.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class    CategoryController {

    @Autowired
    private Reto.Ciclo339.service.CategoryService categoryservice;

    @RequestMapping("/all")
    public List<Category> getClouds(){
        return  categoryservice.getAll();
    }
    @RequestMapping("/{id}")
    public Optional<Category> getCloud(@PathVariable("id")int id){
        return categoryservice.getCloud(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Category save(@RequestBody Category C){
       return categoryservice.save(C);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Category update(@RequestBody Category C){ return categoryservice.update(C);}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
         return categoryservice.deleteCategory(id);
    }




}
