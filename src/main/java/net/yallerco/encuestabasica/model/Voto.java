package net.yallerco.encuestabasica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {
	
	@Id
	@GeneratedValue
	@Column(name = "VOTO_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "OPCION_ID")
	private Opcion opcion;

}
