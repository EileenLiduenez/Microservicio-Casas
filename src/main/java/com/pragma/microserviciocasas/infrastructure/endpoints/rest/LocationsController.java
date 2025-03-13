package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.domain.model.Locations;
import com.pragma.microserviciocasas.domain.ports.in.LocationsServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationsController {

    private final LocationsServicePort locationsServicePort;

    public LocationsController(LocationsServicePort locationsServicePort) {
        this.locationsServicePort = locationsServicePort;
    }

    @PostMapping
    public ResponseEntity<Locations> createLocation(@RequestBody Locations location) {
        Locations newLocation = locationsServicePort.createLocation(location);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }
}
