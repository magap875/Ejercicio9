package com.progIV.Ejercicio9;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Productor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Productor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String cuit;

    // relacion dueña uno a uno con perfilProductor
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "perfil_productor_id", nullable = false, unique = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PerfilProductor perfilProductor;

    // relacion uno a muchos con campo
    @OneToMany(mappedBy = "productor", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Campo> campos;
}
