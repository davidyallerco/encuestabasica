package net.yallerco.encuestabasica.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.yallerco.encuestabasica.model.Voto;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Long>  {
	
	//Seleccionar los votos de una opcion en particular
	@Query(value = "select v.* from Opcion o, Voto v where o.ENCUESTA_ID= ?1 and v.OPCION_ID=o.OPCION_ID", nativeQuery = true)
	public Iterable<Voto> findByEncuesta(Long encuestaId);

}
