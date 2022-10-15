package Reto.Ciclo339.service;

import Reto.Ciclo339.model.Cloud;
import Reto.Ciclo339.repository.CloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CloudService {

    @Autowired
    private CloudRepository cloudRepository;

    public List<Cloud> getAll() {
        return cloudRepository.getAll();
    }

    public Optional<Cloud> getCloud(int id) {
        return cloudRepository.getCloud(id);
    }

    public Cloud save(Cloud C) {
        if (C.getId() == null) {
            return cloudRepository.save(C);
        } else {
            Optional<Cloud> cloAuxiliar = cloudRepository.getCloud(C.getId());
            if (cloAuxiliar.isEmpty()) {
                return cloudRepository.save(C);
            } else {
                return C;
            }
        }
    }

    public Cloud update(Cloud U) {
        if (U.getId() != null) {
            Optional<Cloud> clAuxiliar = cloudRepository.getCloud(U.getId());
            if (clAuxiliar.isPresent()) {
                if (U.getName() != null) {
                    clAuxiliar.get().setName(U.getName());
                    if (U.getBrand() != null) {
                        clAuxiliar.get().setBrand(U.getBrand());
                        if (U.getYear() != null) {
                            clAuxiliar.get().setYear(U.getYear());
                            if (U.getDescription() != null) {
                                clAuxiliar.get().setDescription(U.getDescription());
                            }
                        }
                    }
                }
                return cloudRepository.save(clAuxiliar.get());
            }


        }
        return U;
    }


    public boolean delelteCloud (int id ){
        Boolean deleteAux = getCloud(id).map(client -> {
            cloudRepository.delete(client);
            return true;
        }).orElse(false);
        return deleteAux;
    }

}

















