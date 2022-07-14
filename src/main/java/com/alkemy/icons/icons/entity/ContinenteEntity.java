package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity   // Declara que esta clase es una Entidad
@Table(name = "continente")    // Indica que tabla se esta mapeando
@Getter
@Setter
// indica que se debe hacerse, cuando se llame al delete. (Actualizar tabla continente,
// configurar borrado como true, con el id que le llegue como parametro)
@SQLDelete(sql = "UPDATE continente SET deleted = true WHERE id=?")

// permite diferenciar al momento de ir a buscar informacion, aquellos que fueron eliminados de los que no.
@Where(clause = "deleted=false")

public class ContinenteEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    private boolean deleted = Boolean.FALSE;


}
