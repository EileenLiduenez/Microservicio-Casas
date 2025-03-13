package com.pragma.microserviciocasas.infrastructure.config;

import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.domain.usecases.CategoryUseCase;
import com.pragma.microserviciocasas.domain.ports.in.LocationsServicePort;
import com.pragma.microserviciocasas.domain.ports.out.LocationsPersistencePort;
import com.pragma.microserviciocasas.domain.usecases.LocationsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

    @Bean
    @Primary  //  Indica que este es el bean principal
    public CategoryUseCase categoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        return new CategoryUseCase(categoryPersistencePort);
    }

    @Bean
    public LocationsServicePort locationsService(LocationsPersistencePort locationsPersistencePort) {
        return new LocationsUseCase(locationsPersistencePort);
    }
}
