package Reto.Ciclo339.repository;

import Reto.Ciclo339.model.Client;
import Reto.Ciclo339.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    public List<Client> getALl(){return (List<Client>) clientCrudRepository.findAll();}
    public Optional<Client> getClient(int id) {return clientCrudRepository.findById(id);}
    public Client save(Client C) {return clientCrudRepository.save(C);}
    public void delete(Client C){clientCrudRepository.delete(C);}
    public void delAll(){clientCrudRepository.deleteAll();}
}
