package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.model.Locations;

public interface LocationsServicePort {
    Locations createLocation(Locations location);
}
