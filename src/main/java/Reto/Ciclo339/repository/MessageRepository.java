package Reto.Ciclo339.repository;

import Reto.Ciclo339.model.Client;
import Reto.Ciclo339.model.Message;
import Reto.Ciclo339.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getALl(){return (List<Message>) messageCrudRepository.findAll();}
    public Optional<Message> getMessage(int id) {return messageCrudRepository.findById(id);}
    public Message save (Message c){return messageCrudRepository.save(c);}
    public void delete(Message c){messageCrudRepository.delete(c);}
}