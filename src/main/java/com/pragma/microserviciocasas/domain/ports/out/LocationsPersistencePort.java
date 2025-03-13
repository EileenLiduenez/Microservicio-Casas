package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.model.Locations;
import java.util.Optional;

public interface LocationsPersistencePort {
    Locations save(Locations locations);
    Optional<Locations> findByDepartment(String department);
}
