package com.turismo.proyecto.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Data
@Entity

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Size(max = 100, message = "El nombre del proveedor no debe exceder 100 caracteres")
    private String nombre;

    @NotBlank(message = "El tipo de proveedor es obligatorio")
    @Size(max = 50, message = "El tipo no debe exceder 50 caracteres") // Ejemplo: tour, alojamiento, transporte
    private String tipo;

    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion;

    @NotBlank(message = "La información de contacto es obligatoria")
    private String contacto;

    @Column(nullable = false)
    private double calificacion;

    @OneToMany(mappedBy = "proveedor")
    private List<Experiencia> experiencias;
}