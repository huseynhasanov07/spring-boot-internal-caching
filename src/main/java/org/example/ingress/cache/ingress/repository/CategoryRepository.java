package org.example.ingress.cache.ingress.repository;


import org.example.ingress.cache.ingress.dao.model.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();
}
