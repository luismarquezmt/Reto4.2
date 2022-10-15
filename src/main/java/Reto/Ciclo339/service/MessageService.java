package Reto.Ciclo339.service;


import Reto.Ciclo339.model.Message;
import Reto.Ciclo339.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getALl();
    }

    public Optional<Message> getCloud(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message C) {
        if (C.getIdMessage() == null) {
            return messageRepository.save(C);
        } else {
            Optional<Message> mesAuxiliar = messageRepository.getMessage(C.getIdMessage());
            if (mesAuxiliar.isEmpty()) {
                return messageRepository.save(C);
            } else {
                return C;
            }
        }
    }

    public Message update(Message U) {
        if (U.getIdMessage() != null) {
            Optional<Message> meAux = messageRepository.getMessage(U.getIdMessage());
            if (meAux.isPresent()) {
                if (U.getMessageText() != null){
                    meAux.get().setMessageText(U.getMessageText());
                }
                return messageRepository.save(meAux.get());
            }
        }
        return U;
    }


    public boolean deleteMessage (int id ){
        Boolean deleteAux = getCloud(id).map(client -> {
            messageRepository.delete(client);
            return true;
        }).orElse(false);
        return deleteAux;
    }












}
