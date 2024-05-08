package net.yallerco.encuestabasica.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.yallerco.encuestabasica.model.Encuesta;
import net.yallerco.encuestabasica.model.Voto;
import net.yallerco.encuestabasica.repositories.EncuestaRepository;
import net.yallerco.encuestabasica.repositories.VotoRepository;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class VotoController {
	
	@Autowired
	private VotoRepository votoRepository;

	
	@PostMapping("/encuestas/{encuestaId}/votos")
	public ResponseEntity<?>  crearVoto(@RequestBody Voto voto){
		voto = votoRepository.save(voto);
		HttpHeaders httpHeaders = new HttpHeaders();
		URI newEncuestaUri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(voto.getId()).toUri();
		httpHeaders.setLocation(newEncuestaUri);
		return new ResponseEntity<>(null,httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping("/encuestas/{encuestaId}/votos")
	public Iterable<Voto> buscarPorId(@PathVariable Long encuestaId) {
		return votoRepository.findByEncuesta(encuestaId);
	}
	
	

}
