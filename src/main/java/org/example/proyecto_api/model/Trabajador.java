package org.example.proyecto_api.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="trabajadores")
public class Trabajador extends TimeStampedPersistableObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String puesto;

    @Column(nullable = false)
    private int edad;

    @ManyToOne(optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nominas",nullable = true)
    private Nomina nomina;
}
