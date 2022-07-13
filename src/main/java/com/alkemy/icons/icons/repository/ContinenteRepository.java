package com.alkemy.icons.icons.repository;


import com.alkemy.icons.icons.entity.ContinenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository

// La clase de JPA JpaRepository nos provee todas las operaciones CRUD y muchas mas.
// Por eso solo hacemos que la clase repository herede de JpaRepository para poder
// utilizar todos sus metodos. Ademas esta clase es de tipo entidad, por lo que aprendemos
// que uns subclase puede ser interface y tener clases que la implementen.
// Esto tiene que ser asi para no tener que sobreescribir tode.
// Nos pide que le especifique tipo de entidad y tipo de clave.
// Le decimos que su entidad es de la clase ContinenteEntity y su id es de tipo Long


public interface ContinenteRepository extends JpaRepository<ContinenteEntity,Long> {



}
