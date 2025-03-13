package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryPersistencePort {
    Optional<Category> findByName(String name);
    Category save(Category category);
    Page<Category> findAll(Pageable pageable, String filter); //  Solo este método para paginación
}
