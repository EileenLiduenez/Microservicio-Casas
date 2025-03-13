package com.pragma.microserviciocasas.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.domain.model.Locations;
import com.pragma.microserviciocasas.domain.ports.out.LocationsPersistencePort;
import com.pragma.microserviciocasas.infrastructure.entities.LocationsEntity;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.LocationsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocationsPersistenceAdapter implements LocationsPersistencePort {
    private final LocationsRepository locationsRepository;

    public LocationsPersistenceAdapter(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    @Override
    public Locations save(Locations locations) {
        LocationsEntity entity = new LocationsEntity();
        entity.setCity(locations.getCity());
        entity.setDepartment(locations.getDepartment());
        entity.setDescription(locations.getDescription());

        entity = locationsRepository.save(entity);
        return new Locations(entity.getId(), entity.getCity(), entity.getDepartment(), entity.getDescription());
    }

    @Override
    public Optional<Locations> findByDepartment(String department) {
        return locationsRepository.findByDepartment(department)
                .map(entity -> new Locations(entity.getId(), entity.getCity(), entity.getDepartment(), entity.getDescription()));
    }
}
