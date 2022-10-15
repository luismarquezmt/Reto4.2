package Reto.Ciclo339.repository.crud;

import Reto.Ciclo339.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
