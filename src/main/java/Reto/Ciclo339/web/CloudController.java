package Reto.Ciclo339.web;

import Reto.Ciclo339.model.Cloud;
import Reto.Ciclo339.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cloud")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CloudController {


    @Autowired
    private CloudService cloudService;

    @RequestMapping("/all")
    public List<Cloud> getClouds(){
        return  cloudService.getAll();
    }
    @RequestMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id")int id){
        return cloudService.getCloud(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Cloud save(@RequestBody Cloud C){
       return cloudService.save(C);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Cloud update(@RequestBody Cloud C){return cloudService.update(C);}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id){
         cloudService.delelteCloud(id);
    }


}
