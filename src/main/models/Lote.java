package com.progIV.Ejercicio9;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Lote")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Double superficie;

    // rela muchos a uno con campo
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campo_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Campo campo;

    //rela muchos a uno con suelo
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "suelo_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Suelo suelo;

    //relacion con siembra
    @OneToMany(mappedBy = "lote", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Siembra> siembras = new ArrayList<>();
}
