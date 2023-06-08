package com.dawes.modelo;

import com.dawes.enums.TipoTratamiento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tratamiento",uniqueConstraints = @UniqueConstraint (columnNames = "nombre"))
public class TratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtratamiento;
	private String nombre;
	@Column (length = 40) 
	private String descripcion;
	private TipoTratamiento tipo;
	
	public TratamientoVO(String nombre, String descripcion, TipoTratamiento tipo) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.tipo=tipo;
	}
}
