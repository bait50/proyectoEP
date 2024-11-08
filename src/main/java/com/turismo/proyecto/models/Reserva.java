package com.turismo.proyecto.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @NotNull(message = "La fecha de reserva es obligatoria")
    private LocalDate fechaReserva;

    @NotBlank(message = "El estado de la reserva es obligatorio")
    private String estado; // Ejemplo: pendiente, confirmada, cancelada

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "experiencia_id", nullable = false)
    private Experiencia experiencia;

    
}
