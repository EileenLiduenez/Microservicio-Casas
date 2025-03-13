package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.model.Locations;
import com.pragma.microserviciocasas.domain.ports.in.LocationsServicePort;
import com.pragma.microserviciocasas.domain.ports.out.LocationsPersistencePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class LocationsUseCase implements LocationsServicePort {
    private final LocationsPersistencePort locationsPersistencePort;

    public LocationsUseCase(LocationsPersistencePort locationsPersistencePort) {
        this.locationsPersistencePort = locationsPersistencePort;
    }

    @Override
    public Locations createLocation(Locations location) {
        // Validar que el nombre del departamento no se repita
        Optional<Locations> existingLocation = locationsPersistencePort.findByDepartment(location.getDepartment());
        if (existingLocation.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El departamento ya existe.");
        }

        // Validar que los nombres no excedan 50 caracteres
        if (location.getCity().length() > 50 || location.getDepartment().length() > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de ciudad o departamento es demasiado largo (máximo 50 caracteres).");
        }

        // Validar que la descripción no exceda 120 caracteres
        if (location.getDescription().length() > 120) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La descripción es demasiado larga (máximo 120 caracteres).");
        }

        return locationsPersistencePort.save(location);
    }
}
