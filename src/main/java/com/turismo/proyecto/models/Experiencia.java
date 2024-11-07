package com.turismo.proyecto.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity

public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperiencia;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no debe exceder 100 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 500, message = "La descripción no debe exceder 500 caracteres")
    private String descripcion;

    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 50, message = "La categoría no debe exceder 50 caracteres")
    private String categoria; // Ejemplo: aventura, cultural, etc.

    @NotBlank(message = "La temporada es obligatoria")
    private String temporada; // Ejemplo: invierno, verano, etc.

    @Column(nullable = false)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @OneToMany(mappedBy = "experiencia")
    private List<Reserva> reservas;
}
