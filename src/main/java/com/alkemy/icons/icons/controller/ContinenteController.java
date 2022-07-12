package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Declaramos que la clase es un controlador
@RestController

// Definimos la url que vamos a utilizar para acceder a este controller.
@RequestMapping("continentes")


public class ContinenteController {

   // La clase controller tiene un atributo de tipo objeto de clase ContinenteService.
   // Es decir, utilizar un atributo  de esta clase (por un metodo) es al mismo tiempo utilizar un
   // objeto de la la clase ContinenteService

                // Buscamos que el servicio guarde el continente.
   @Autowired   // Enlaza ambas clases Controllador y Servicio.
   private ContinenteService continenteService;

   // Definimos el metodo save que recibe un objeto de la clase ContinenteDTO y
   // manejamos la respuesta de nuestro endpoint con ashuda de la clase ResponseEntity

   @PostMapping  // Establece que el vervo de esta solicitud es POST, asociado a este metodo
   public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
      ContinenteDTO contineneteGuardado = continenteService.save(continente);
      return ResponseEntity.status(HttpStatus.CREATED).body(contineneteGuardado);
       // respondemos 201 (exito) y un body
   }
// El controller no maneja la logica de guardado unicamente recibe la solicitud
// Y devuelve una respuesta (entre medio transfiere la informacion al servicio)



}
