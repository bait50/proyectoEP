package com.turismo.proyecto.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity


public class ItinerarioExperiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItinerarioExperiencia;

    @ManyToOne
    @JoinColumn(name = "itinerario_id", nullable = false)
    private Itinerario itinerario;

    @ManyToOne
    @JoinColumn(name = "experiencia_id", nullable = false)
    private Experiencia experiencia;

    private int orden;
} 

