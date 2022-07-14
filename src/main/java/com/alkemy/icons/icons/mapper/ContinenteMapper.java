package com.alkemy.icons.icons.mapper;
import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
// Paso 1
// Crear metodo de conversion de objeto DTO a objeto Entidad.
// Metodo  continenteDTO2Entity  recibe dto ingresado por el usuario.
// Crea un objeto de tipo, ContinenteEntity y setea los valores de sus
// atributos con los valores de los atributos del objeto recibido.

// Paso 2
// Inyectar un objeto del   Mapper   en el   Servicio  para poder utilizarlo.
// Para ello creamos un objeto de esta clase en ContinenteServiceImp y hacemos
// que su metodo "save" lo utilice para hacer la conversion.

@Component  // declaro que es de tipo componente, esro me va a permitir inyctarlo en otras clases
public class ContinenteMapper {

    // recibe un dto, lo transforma a entidad y retorna la entidad
    public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto){
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(dto.getImagen());
        continenteEntity.setDenominacion(dto.getDenominacion());
        continenteEntity.setDeleted(dto.isDeleted());
        return continenteEntity;
    }

    // recibe una entidad, la transforma a dto y la retorna
     public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity){
     ContinenteDTO dto = new ContinenteDTO();
     dto.setId(entity.getId());  // regresando de la bd ya tiene id asignado.
     dto.setImagen(entity.getImagen());
     dto.setDenominacion(entity.getDenominacion());
     dto.setDeleted(entity.isDeleted());
     return dto;
    }

    //                  PARA BUSCAR CONTINENTES
    // Metodo que recibe un list de entidades (provenientes de la BD),
    // transforma a DTOs y retorna list de DTOs.

    public List<ContinenteDTO> continenteEntityList2DTOList(List<ContinenteEntity> entities){

        List<ContinenteDTO> dtos = new ArrayList<>();  // Creo list de DTOs

        for (ContinenteEntity entity : entities){  // p/cada elemento del list de entidades
        //  transforma ese elemento de entidad a objeto y almacenalo en el list de DTOs
            dtos.add(this.continenteEntity2DTO(entity));
        }
        // retorna ese list de DTOs
        return dtos;
    }

}
