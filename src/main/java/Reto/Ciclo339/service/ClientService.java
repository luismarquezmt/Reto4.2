package Reto.Ciclo339.service;

import Reto.Ciclo339.model.Client;
import Reto.Ciclo339.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getALl();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client C) {
        if (C.getIdClient() == null) {
            return clientRepository.save(C);
        } else {
            Optional<Client> cliAux = clientRepository.getClient(C.getIdClient());
            if (cliAux.isEmpty()) {
                return clientRepository.save(C);
            } else {
                return C;
            }
        }
    }

    public Client update(Client U) {
        if (U.getIdClient() != null) {
            Optional<Client> clAuxiliar = clientRepository.getClient(U.getIdClient());
            if (clAuxiliar.isPresent()) {
                if (U.getName() != null) {
                    clAuxiliar.get().setName(U.getName());
                    if (U.getEmail() != null) {
                        clAuxiliar.get().setEmail(U.getEmail());
                        if (U.getPassword() != null) {
                            clAuxiliar.get().setPassword(U.getPassword());
                            if (U.getAge() != null) {
                                clAuxiliar.get().setAge(U.getAge());
                            }
                        }
                    }
                }
                return clientRepository.save(clAuxiliar.get());
            }
        }
        return U;
    }



    public boolean delelteClient (int id ){
        Boolean deleteAux = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return deleteAux;
    }



}



















