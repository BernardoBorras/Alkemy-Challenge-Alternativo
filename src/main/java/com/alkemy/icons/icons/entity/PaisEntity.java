package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity   // Declaramos esta clase como Entidad
@Table    // Indica contra que tabla mapea la Entidad2
@Getter
@Setter

public class PaisEntity {

    @Id
    @Column // Si columna lleva mismo nombre que atributo en clase. No es necesario setearlo con @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String imagen;
    private String denominacion;
    @Column(name = "cant_habitantes")    // setteamos name con @column por que BD no toma notacion camello.
    private Long cantidadHabitantes;     // En la clase, el atributo mantiene su nombre.
    private Long superficie;  // m2




    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    // Identifica la entidad propietaria de la relacion.
    // Define la columna contenedora de la llave foranea.
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)


    // Este objeto solo se va a utilizar para traer continentes enteros cuando queramos traer
    // una lista de paises, estos van a venir con su continente entero.
    private ContinenteEntity continente;



    // Atributo continenteId renombrado como "continente_id" es la definicion de la columna
    // que contiene la llave foranea de la Entidad B por definicion. Esta columna se utiliza
    // para la creacion y actualizacion de paises.
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;  // Instanciamos un objeto de la clase Continente.










1





    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE })
    @JoinTable(                                         // Configura detalles de la relacion
            name = "icon_pais",                         // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();



}