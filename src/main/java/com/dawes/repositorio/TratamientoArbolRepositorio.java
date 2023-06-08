package com.dawes.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.TratamientoArbolVO;


@Repository
public interface TratamientoArbolRepositorio extends CrudRepository<TratamientoArbolVO, Integer>{

	@Query("select c from TratamientoArbolVO c where arbol=:arbol")
	Optional<List<TratamientoArbolVO>> findAllByArbol(ArbolVO arbol);
}