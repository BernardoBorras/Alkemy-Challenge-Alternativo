package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity   // Declara que esta clase es una Entidad
@Table    // Indica que tabla se esta mapeando

@Getter
@Setter

public class IconEntity {

    // Atributos -> Columnas de la tabla IconEntity
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imagen;   // URL
    private String denominacion;
    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd") // Define como va a llegar el formato, patron.
    private LocalDate fechaCreacion;
    private Long altura;
    private Long historia;



    // Definicion del lado del Owner. Consecuentemente, al crear un registro de
    // Pais, este puede recibir un listado de iconos asociados. Pero no al revez.
    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<PaisEntity> paises = new ArrayList<>();




}