package com.alkemy.icons.icons.service;


import com.alkemy.icons.icons.dto.ContinenteDTO;
import org.springframework.stereotype.Service;

@Service
public class ContinenteService {

// en esta oportunidad al crear un objeo de la clase ContinenteDTO lo llamamos "dto"
//  por que en esta capa si va a tener logica. A diferencia de la capa de controller
// que unicamente fue utilizado para transportar informacion.

// Este metodo recibe un objeto de la clase ContinenteDTO = "dto"  por parte de la capa
// Controller. Y retorna el mismo DTO que me llego a mi servicio, por que quieremos probar
// que el endpoin funciona correctamente enviando una solicitud desde postman y viendo que la
// respuesta llega correctamente. Para saber que ya soy capaz de interactuar con un endpoint
// Que ese endpoint puede llegar hasta la capa de servicio y me puede devolver una respuesta.



    public ContinenteDTO save(ContinenteDTO dto){
      // TODO: falta guardar continente en la base de datos (solo llegamos hasta la capa service y retornamos la misma informacion que se ingreso)
      System.out.println("Guardar continente");
      return dto;
    }




}
