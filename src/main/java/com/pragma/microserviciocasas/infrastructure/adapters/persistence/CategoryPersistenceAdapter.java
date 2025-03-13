package com.pragma.microserviciocasas.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.domain.model.Category;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.infrastructure.entities.CategoryEntity;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;

    public CategoryPersistenceAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity entity = new CategoryEntity(category.getId(), category.getName(), category.getDescription());
        entity = categoryRepository.save(entity);
        return new Category(entity.getId(), entity.getName(), entity.getDescription());
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name)
                .map(entity -> new Category(entity.getId(), entity.getName(), entity.getDescription()));
    }

    @Override
    public Page<Category> findAll(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return categoryRepository.findByNameContainingIgnoreCase(filter, pageable)
                    .map(entity -> new Category(entity.getId(), entity.getName(), entity.getDescription()));
        }
        return categoryRepository.findAll(pageable)
                .map(entity -> new Category(entity.getId(), entity.getName(), entity.getDescription()));
    }
}
