package org.example.proyecto_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "nominas")
public class Nomina extends TimeStampedPersistableObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double bruto;

    @Column(nullable = false)
    private Double neto;

}
