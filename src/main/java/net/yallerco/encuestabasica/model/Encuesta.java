package net.yallerco.encuestabasica.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encuesta {

	@Id
	@GeneratedValue
	@Column(name = "ENCUESTA_ID")
	private Long id;
	
	@Column(name = "pregunta")
	private String pregunta;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENCUESTA_ID")
	@OrderBy
	private Set<Opcion> opciones;
}
