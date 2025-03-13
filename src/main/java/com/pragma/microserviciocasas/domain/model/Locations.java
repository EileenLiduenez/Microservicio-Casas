package com.pragma.microserviciocasas.domain.model;

public class Locations {
    private Long id;
    private String city;
    private String department;
    private String description;

    public Locations(Long id, String city, String department, String description) {
        this.id = id;
        this.city = city;
        this.department = department;
        this.description = description;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

