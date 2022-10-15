package Reto.Ciclo339.web;

import Reto.Ciclo339.model.Message;
import Reto.Ciclo339.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/all")
    public List<Message> getMessages(){return messageService.getAll();}
    @RequestMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id")int id) {return messageService.getCloud(id);}
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Message save(@RequestBody Message C){return messageService.save(C);}

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Message update(@RequestBody Message C){
        return messageService.update(C);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id){
         messageService.deleteMessage(id);
    }

}
