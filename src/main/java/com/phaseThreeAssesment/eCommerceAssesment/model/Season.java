package com.phaseThreeAssesment.eCommerceAssesment.model;

import jakarta.persistence.*;

@Entity
@Table(name="season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
