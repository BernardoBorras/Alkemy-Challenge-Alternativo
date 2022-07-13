package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContinenteServiceImp implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;

    @Autowired
    private ContinenteRepository continenteRepository;


    public ContinenteDTO save(ContinenteDTO dto){
        // objeto entidad creado para almacenar dto transformado a entidad por mapper.
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
        // objeto entidad creado para almacenar la entidad guardada y retornada por repository.
        ContinenteEntity entitySaved = continenteRepository.save(entity); // El metodo del objeto repository guarda
                                                                          //  la entidad en la BD y nos la devuelve.
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        return result;
    }

    // Traer todos los continentes de la BD - Metodo que retorna un List de DTOs
    public List<ContinenteDTO> getAllContinentes(){
        // Crea un list de Entidades y lo inicializo con el el list de objetos que retorna findAll()
        //                 Recordamos que la clase ContinenteRepository es subclase de JpaRepository
        //                 por lo que puede utilizar todos sus metodos para interactuar con la BD.
        //                 YA TENGO UN LIST DE ENTIDADES CON LOS REGISTROS DE LA BD.
        List<ContinenteEntity> entities = continenteRepository.findAll();

        // Creo un List de DTOs y lo inicializo con. La conversion del list de entidades a DTOs.
        //           Recordamos que la clase ContinenteMapper contiene el metodo para transformar
        //           Entitidades a DTO y tambien Listas de Entidades a Lista de DTOs.
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);

        // Retornamos un la Lista de DTOs (lista de registros de la tabla continentes)
        return result;
    }

}

