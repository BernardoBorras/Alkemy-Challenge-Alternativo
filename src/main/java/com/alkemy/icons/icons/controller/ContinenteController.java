package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continentes")

public class ContinenteController {

   @Autowired  // Sirve para Enlazar Controllador y Servicio.
   private ContinenteService continenteService;  // Sirve para inyectar objeto.



   @GetMapping
   public ResponseEntity<List<ContinenteDTO>> getAll(){
      List<ContinenteDTO> continentes = continenteService.getAllContinentes();
      return ResponseEntity.ok().body(continentes);

   }


   @DeleteMapping("/{id}") // Definimos path adicional para indicar id del continente.
   public ResponseEntity<Void> delete(@PathVariable Long id){
      this.continenteService.delete(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }



   @PostMapping
   public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
      ContinenteDTO contineneteGuardado = continenteService.save(continente);
      return ResponseEntity.status(HttpStatus.CREATED).body(contineneteGuardado);
   }

}
