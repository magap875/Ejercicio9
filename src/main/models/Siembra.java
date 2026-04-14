package com.progIV.Ejercicio9;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Siembra")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Siembra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private String estado;

    // relacion muchos a 1 con lote
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lote_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Lote lote;

    // relacion muchos a 1 con cultivo
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cultivo_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Cultivo cultivo;

    // relacion muchos a muhcos con agroquimico
    @ManyToMany
    @JoinTable(name = "siembraXagroquimico", joinColumns = @JoinColumn(name = "siembra_id"), inverseJoinColumns = @JoinColumn(name = "agroquimico_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Agroquimico> agroquimicos;
}
