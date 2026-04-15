package com.progIV.Ejercicio9;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Suelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Suelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Double ph;

    //relacion con lote
    @OneToMany(mappedBy = "suelo", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Lote> lotes = new ArrayList<>();
}
