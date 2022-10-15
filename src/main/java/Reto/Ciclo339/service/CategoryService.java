package Reto.Ciclo339.service;

import Reto.Ciclo339.model.Category;
import Reto.Ciclo339.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCloud(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category C) {
        if (C.getId() == null) {
            return categoryRepository.save(C);
        } else {
            Optional<Category> caAuxiliar = categoryRepository.getCategory(C.getId());
            if (caAuxiliar.isEmpty()) {
                return categoryRepository.save(C);
            } else {
                return C;
            }
        }
    }

    public Category update(Category u) {
        if (u.getId() != null) {
            Optional<Category> caAuxiliar = categoryRepository.getCategory(u.getId());
            if (caAuxiliar.isPresent()) {
                if (u.getName() != null) {
                    caAuxiliar.get().setName(u.getName());
                    if (u.getDescription() != null) {
                        caAuxiliar.get().setDescription(u.getDescription());
                    }
                }
                return categoryRepository.save(caAuxiliar.get());
            }
        }
        return u;
    }

    public void delete (int id){
        Optional<Category> caAuxiliar=categoryRepository.getCategory(id);
        if(caAuxiliar.isPresent()) {
            categoryRepository.delete(caAuxiliar.get());
        }
        else ;
    }


    public boolean deleteCategory (int id ){
        Boolean deleteAux = getCloud(id).map(client -> {
            categoryRepository.delete(client);
            return true;
        }).orElse(false);
        return deleteAux;
    }


 }
