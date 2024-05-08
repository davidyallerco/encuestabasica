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
import net.yallerco.encuestabasica.repositories.EncuestaRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EncuestaController {
	
	@Autowired
	private EncuestaRepository encuestaRepository;
	
	@GetMapping("/encuestas")
	public ResponseEntity<Iterable<Encuesta>> listarTodos(){
		return new ResponseEntity<>(encuestaRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/encuestas")
	public ResponseEntity<?>  crearEncuesta(@RequestBody Encuesta encuesta){
		encuesta = encuestaRepository.save(encuesta);
		HttpHeaders httpHeaders = new HttpHeaders();
		URI newEncuestaUri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(encuesta.getId()).toUri();
		httpHeaders.setLocation(newEncuestaUri);
		return new ResponseEntity<>(null,httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping("/encuestas/{encuestaId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long encuestaId) {
		Optional<Encuesta> encuesta = encuestaRepository.findById(encuestaId);
		if (encuesta.isPresent()) {
			return new ResponseEntity<>(encuesta, HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/encuestas/{encuestaId}")
	public ResponseEntity<?> actualizarEncuesta(@RequestBody Encuesta encuesta , @PathVariable Long encuestaId){
		encuesta.setId(encuestaId);
		encuestaRepository.save(encuesta);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/encuestas/{encuestaId}")
	public ResponseEntity<?> eliminarEncuesta(@PathVariable  Long encuestaId){
		encuestaRepository.deleteById(encuestaId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
