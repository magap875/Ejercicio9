package com.progIV.Ejercicio9;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Agroquimico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agroquimico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String composicion;

    //relacion mucho a mucho con siembras
    @ManyToMany(mappedBy = "agroquimicos")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Siembra> siembras = new ArrayList<>();
}
