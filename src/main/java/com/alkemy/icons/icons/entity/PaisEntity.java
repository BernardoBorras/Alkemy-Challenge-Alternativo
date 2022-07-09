package com.alkemy.icons.icons.entity;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pais")
@Getter
@Setter

public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie;

    // Estando en la clase de Pais definimos una relacion de N a 1
    // N paises pueden pertenecer a 1 continente
    //  En la clase pais creamos un atributo correspondiente a una
    //  columna en la tabla pais. Llamado "continente"


    // FetchType.EAGER : Significa que la inicializacion va a ser de tipo temprana
    //                   cuando se solicite un registro de la tabla pais, si o si va a
    //                   venir con sus continentes.
    //
    // cascade = CascadeType.ALL : Para que las operaciones sean consecuentes. Es decir
    //              si borro un pais, se va a borrar ese pais en la tabla pais, pero
    //              tambien , en la tabla continente, se va a borrar la existencia de ese
    //              pais.
    //
    // @JoinColumn   como voy a unir los elementos de esta entidad (paises) con los
    //                los elementos de la tabla continente. Lo va a hacer a travez del
    //                atributo "continente_id" (continenteId). Es decir, en la tabla de
    //                Paises, la columna continente va ser el nexo con la tabla continene.
    //
    // insertable = false y  :   Ambos son false, por que se usa unicamente para
    // updatable = false         obtener informacion.

    //  En resumen esta seccion sirve para ir a buscar informacion. Trae un objeto de tipo continente entero.


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continenete_id", insertable = false, updatable = false)
    private ContinenteEntity continente;  // Instanciamos una variable de tipo, clase Continente.


   // Esta seccion sirve para guardar y actualizar la columna continenteId.

    @Column(name = "continente_id", nullable = false) // renombramos para BD
    private Long continenteId;   // id del continente con el que se va a enlazar el pais



    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })


    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();




}




