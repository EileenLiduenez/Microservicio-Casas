package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.model.Category;
import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category createCategory(Category category) {
        Optional<Category> existingCategory = categoryPersistencePort.findByName(category.getName());
        if (existingCategory.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La categoría ya existe.");
        }
        return categoryPersistencePort.save(category);
    }

    @Override
    public Page<Category> getCategories(Pageable pageable, String filter) {
        // Implement the logic to get categories with pagination and filtering
        return categoryPersistencePort.findAll(pageable, filter);
    }
}