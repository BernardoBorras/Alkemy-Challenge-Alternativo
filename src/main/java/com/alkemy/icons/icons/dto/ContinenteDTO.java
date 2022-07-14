package com.alkemy.icons.icons.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ContinenteDTO {

    // Aca definimos lo atributos que vamos a vecesitar para poder llevar y traer los datos
    // del continente
    private Long id;
    private String imagen;
    private String denominacion;
    private boolean deleted;
}
