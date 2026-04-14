package com.progIV.Ejercicio9;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cultivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipoGrano;


    //relacion uno a muchos con siembra
    @OneToMany(mappedBy = "cultivo", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Siembra> siembra;
}
