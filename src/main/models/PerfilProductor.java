package com.progIV.Ejercicio9;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PerfilProductor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilProductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contactoEmergencia;

    @Column
    private String observaciones;

    // relacion 1 a 1 con productor. productor es el lado de la fk
    @OneToOne(mappedBy = "perfilProductor", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Productor productor;
}
