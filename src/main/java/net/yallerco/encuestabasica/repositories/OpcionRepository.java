package net.yallerco.encuestabasica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.yallerco.encuestabasica.model.Opcion;

@Repository
public interface OpcionRepository extends CrudRepository<Opcion, Long>  {

}
