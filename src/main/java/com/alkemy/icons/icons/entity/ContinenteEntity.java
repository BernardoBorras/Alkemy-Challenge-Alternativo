package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity   // Declara que esta clase es una Entidad
@Table(name="contienente")    // Indica que tabla se esta mapeando
@Getter
@Setter

public class ContinenteEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    // faltaria coidades con iconos geograficos asociados --->  cardinalidad

}
