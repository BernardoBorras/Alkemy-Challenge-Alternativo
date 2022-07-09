package com.alkemy.icons.icons.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter
@Setter


public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;   // URL

    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd") // anotacion para definir como vaa llegar el formato, un patron.
    private LocalDate fechaCreacion;

    private Long altura;

    private Long historia;





    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<PaisEntity> paises = new ArrayList<>();






    //  Añadir y remover paises
    public void addPais(PaisEntity pais) {
        this.paises.add(pais);
    }

    public void removePais(PaisEntity pais) {
        this.paises.remove(pais);
    }

}
