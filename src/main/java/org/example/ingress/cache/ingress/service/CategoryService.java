package org.example.ingress.cache.ingress.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.ingress.cache.ingress.dao.model.CategoryEntity;
import org.example.ingress.cache.ingress.dao.model.request.CategoryRequest;
import org.example.ingress.cache.ingress.dao.model.response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService {
    CategoryHistoryServiceHandler categoryHistoryServiceHandler;

    public List<CategoryResponse> findAll() {
        return categoryHistoryServiceHandler.findAll().stream().map(
                categoryEntity -> CategoryResponse
                        .builder()
                        .id(categoryEntity.getId())
                        .name(categoryEntity.getName())
                        .build()
        ).toList();
    }

    public void save(CategoryRequest categoryRequest) {
        categoryHistoryServiceHandler.save(CategoryEntity
                .builder()
                .name(categoryRequest.getName())
                .build());
        //   categoryHistoryServiceHandler.clearCache();
    }

    public CategoryResponse findById(Long id) {
        CategoryEntity categoryEntity = categoryHistoryServiceHandler.findById(id);
        return CategoryResponse
                .builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }

    public void update(Long id, String name) {
        categoryHistoryServiceHandler.update(id, name);
    }

    public void delete(Long id) {
        categoryHistoryServiceHandler.delete(id);
    }

}
