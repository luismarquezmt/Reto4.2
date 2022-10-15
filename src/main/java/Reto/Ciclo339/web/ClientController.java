package Reto.Ciclo339.web;

import Reto.Ciclo339.model.Client;
import Reto.Ciclo339.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/all")
    public List<Client> getClients(){
        return  clientService.getAll();
    }
    @RequestMapping("/{id}")
    public Optional<Client> getClients(@PathVariable("idClient")int id){
        return clientService.getClient(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Client save(@RequestBody Client C){
       return clientService.save(C);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Client update (@RequestBody Client C ){return clientService.update(C);}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id){
         clientService.delelteClient(id);
    }


}
