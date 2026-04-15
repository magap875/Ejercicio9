package com.progIV.Ejercicio9;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Campo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Campo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    
    @Column (nullable = false)
    private Double hectareasTotales;

    //relacion dueña con productor - 1 a muchos
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productor_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Productor productor;

    //relacion uno a muchos con lote
    @OneToMany(mappedBy = "campo", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Lote> lotes = new ArrayList<>();
}
