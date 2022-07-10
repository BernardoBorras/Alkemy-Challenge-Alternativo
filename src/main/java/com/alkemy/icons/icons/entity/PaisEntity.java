package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity   // Declaramos esta clase como Entidad
@Table    // Indica contra que tabla mapea la Entidad
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







    //  Buscar informacion, Traer un objeto de tipo continente.
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "contienente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    // Guardar y actualizar la columna continenteId.
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;  // Instanciamos un objeto de la clase Continente.




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