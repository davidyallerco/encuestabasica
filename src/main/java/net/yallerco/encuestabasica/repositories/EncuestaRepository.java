package net.yallerco.encuestabasica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.yallerco.encuestabasica.model.Encuesta;

@Repository
public interface EncuestaRepository  extends CrudRepository<Encuesta, Long>{

}
