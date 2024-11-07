package com.turismo.proyecto.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Itinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItinerario;

    @NotBlank(message = "El nombre del itinerario es obligatorio")
    @Size(max = 100, message = "El nombre del itinerario no debe exceder 100 caracteres")
    private String nombre;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "itinerario")
    private List<ItinerarioExperiencia> itinerarioExperiencias;

}
